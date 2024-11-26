package controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.domain.CartProduct;
import model.domain.Order;
import model.domain.OrderProduct;
import model.domain.Product;
import model.service.CartProductManager;
import model.service.ExistingOrderException;
import model.service.OrderManager;
import model.service.OrderProductManager;

public class CreateOrderController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderManager orderMan = OrderManager.getInstance();
		OrderProductManager orderProductMan = OrderProductManager.getInstance();
        CartProductManager cartProductMan = CartProductManager.getInstance();
		
		try {
            // 파라미터 추출 및 변환
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
            String purchaser = request.getParameter("purchaser");
            String purPhone = request.getParameter("purPhone");
            String recipient = request.getParameter("recipient");
            String recPhone = request.getParameter("recPhone");
            String deliveryAddress = request.getParameter("deliveryAddress");
            int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date utilDate = sdf.parse(request.getParameter("deliveryDate"));
            java.sql.Date deliveryDate = new java.sql.Date(utilDate.getTime());
            System.out.println("deliveryDate: "+ deliveryDate);

            // Order 객체 생성
            Order order = new Order();
            order.setUserId(userId);
            order.setPurchaser(purchaser);
            order.setPurPhone(purPhone);
            order.setRecipient(recipient);
            order.setRecPhone(recPhone);
            order.setDeliveryAddress(deliveryAddress);
            order.setTotalPrice(totalPrice);
            order.setDeliveryDate(deliveryDate);
            order.setOrderAt(new Date()); // 현재 시간 설정

         // 세션에서 장바구니 상품 데이터 가져오기
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> cartProducts = (List<Map<String, Object>>) session.getAttribute("cartProducts");

            int result = -1;
            if (cartProducts != null) {
                System.out.println("Cart products size: " + cartProducts.size());

                int orderId = orderMan.create(order); // Order 생성
                System.out.println("Generated Order ID: " + orderId);

                for (Map<String, Object> cartProductDetail : cartProducts) {
                    CartProduct cartProduct = (CartProduct) cartProductDetail.get("cartProduct");
                    Product product = (Product) cartProductDetail.get("productDetail");

                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrderId(orderId);
                    orderProduct.setProductId(cartProduct.getProductId());
                    orderProduct.setQuantity(cartProduct.getQuantity());
                    orderProduct.setOrderItemPrice(product.getPrice());

                    System.out.println("OrderProduct details: " + orderProduct);

                    result = orderProductMan.createOrderProduct(orderProduct); // OrderProduct 생성
                    System.out.println("OrderProduct creation result: " + result);

                    if (result > 0) {
                        result = cartProductMan.removeCartProduct(userId, cartProduct.getProductId()); // 장바구니 삭제
                        System.out.println("Cart product removal result: " + result);
                    }
                }
            } else if (cartProducts == null) {
                System.out.println("No cartProducts found in session.");
            }
            if (result > 0) {
                return "redirect:/purchase/purchaseList";
            } else {
                response.getWriter().write("Failed to create order.");
                return "/purchase/purchasePage.jsp";
            }
        } catch (ExistingOrderException e) {
            response.getWriter().write("Error: " + e.getMessage());
            return "/purchase/purchasePage.jsp";
        }
	}
}
