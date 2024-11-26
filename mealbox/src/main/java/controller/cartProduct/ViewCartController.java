package controller.cartProduct;

import model.domain.CartProduct;
import model.domain.Product;
import model.service.CartProductManager;
import model.service.ProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCartController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CartProductManager cartProductMan = CartProductManager.getInstance();
        ProductManager productManager = ProductManager.getInstance();

        try {
            // 사용자 ID 추출
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute(UserSessionUtils.USER_SESSION_KEY);

            List<CartProduct> cartProductList = cartProductMan.getCartProducts(userId);
            
            // 장바구니 상품 데이터
            List<Map<String, Object>> combinedProductDetails = new ArrayList<>();
            for (CartProduct cartProduct : cartProductList) {
                Map<String, Object> productDetail = new HashMap<>();
                productDetail.put("cartProduct", cartProduct);
                Product product = productManager.getDetail(cartProduct.getProductId());
                productDetail.put("productDetail", product);
                combinedProductDetails.add(productDetail);
            }

         // 데이터 확인 (디버깅)
            System.out.println("Combined Product Details: " + combinedProductDetails.size());
            for (Map<String, Object> detail : combinedProductDetails) {
                System.out.println(detail);
            }
            
            int totalPrice = cartProductMan.calculateTotalCartPrice(userId);
            
            request.setAttribute("totalPrice", totalPrice);
            request.setAttribute("combinedProductDetails", combinedProductDetails);
            
            return "/cart/cartPage.jsp"; 
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "redirect:/product";
        }
    }
}
