package controller.cartProduct;

import model.domain.CartProduct;
import model.domain.Product;
import model.service.CartProductManager;
import model.service.ProductManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

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
            String userId = "ninja2";

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

            request.setAttribute("combinedProductDetails", combinedProductDetails);
            
            return "/cart/cartPage.jsp"; 
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "오류 발생: " + e.getMessage());
            return "redirect:/product";
        }
    }
}
