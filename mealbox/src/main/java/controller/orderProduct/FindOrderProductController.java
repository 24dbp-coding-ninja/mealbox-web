package controller.orderProduct;

import model.domain.OrderProduct;
import model.domain.Product;
import model.service.OrderProductManager;
import model.service.ProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class FindOrderProductController implements Controller   {
	OrderProductManager orderProductManager = OrderProductManager.getInstance();
    ProductManager productManager = ProductManager.getInstance();
	

	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 try {
	            // URL에서 orderId와 lineNo 추출
	            String path = request.getRequestURI();
	            String[] pathParts = path.split("/");
	            int orderId = Integer.parseInt(pathParts[pathParts.length - 2]);
	            int lineNo = Integer.parseInt(pathParts[pathParts.length - 1]);

	            // 주문 상품 정보 조회
	            OrderProduct orderProduct = orderProductManager.findOrderProduct(orderId, lineNo);
	            if (orderProduct == null) {
	                request.setAttribute("message", "해당 주문 상품을 찾을 수 없습니다.");
	                return "/error/errorPage.jsp";
	            }

	            // Product 정보 조회
	            Product product = productManager.getDetail(orderProduct.getProductId());
	            if (product == null) {
	                request.setAttribute("message", "상품 정보를 찾을 수 없습니다.");
	                return "/purchase/orderProductDetail.jsp";
	            }

	            // JSP에 데이터 전달
	            request.setAttribute("orderProduct", orderProduct);
	            request.setAttribute("product", product);

	            return "/purchase/orderProductDetail.jsp";
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("message", "오류 발생: " + e.getMessage());
	            return "/error/errorPage.jsp";
	        }
	    }
	}