package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.cartProduct.*;
import controller.comm.*;
import controller.order.*;
import controller.orderProduct.*;
import controller.product.*;
import controller.comm.*;
import controller.review.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 여기서부터 코드닌자 코드 추가
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        
        // 리뷰 관련 매핑 추가
        mappings.put("/review/items", new ForwardController("/review/reviewForm.jsp"));
        mappings.put("/review/create", new CreateReviewController());
        mappings.put("/review/update", new UpdateReviewController());
        mappings.put("/review/delete", new DeleteReviewController());
        
        //영선-로그인, 회원가입, adminUserPage
        mappings.put("/user/login/form", new ForwardController("/user/login.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/join/form", new ForwardController("/user/join.jsp"));
        mappings.put("/user/createUser", new CreateUserController());
        mappings.put("/user/updateUser", new UpdateUserController());
        mappings.put("/user/deleteUser", new DeleteUserController());
        mappings.put("/user/listUser", new ListUserController());
        
        // 윤지-main 및 admin, product Detail 페이지
        mappings.put("/product", new ListProductController());
        mappings.put("/admin", new ReadProductController());
        mappings.put("/admin/create", new CreateProductController());
        mappings.put("/admin/update", new UpdateProductController());
        mappings.put("/admin/delete", new DeleteProductController());
        mappings.put("/product/detail", new ProductController());
        
        // 고은 -myPage
        mappings.put("/user/readUser", new ForwardController("/user/myPage.jsp"));

        // 고은-장바구니 관련 request URI 추가
        mappings.put("/cart/add", new AddCartProductController());
        mappings.put("/cart/update", new UpdateCartProductController());
        mappings.put("/cart/remove", new RemoveCartProductController());
        mappings.put("/cart/view", new ViewCartController());
        mappings.put("/cart/totalPrice", new CalculateTotalCartPriceController());
        mappings.put("/cart/cartList",new ForwardController("/cart/cartPage.jsp"));
        
        // 고은-주문 관련 request URI 추가
        mappings.put("/order/create", new CreateOrderController()); // 주문하기 주문 정보 저장
        mappings.put("/order/update", new UpdateOrderController()); // 주문 정보 수정
        mappings.put("/orderProduct/update", new UpdateOrderProductController()); // 주문 상품 수정
        mappings.put("/orderProduct/create", new CreateOrderProductController()); // 주문하기 주문 상품 저장
        mappings.put("/orders/user", new FindOrdersInUserController()); // 사용자의 모든 주문 조회
        mappings.put("/orders/{orderId}/products/{lineNo}", new FindOrderProductController()); // 특정 주문의 상품 조회
        mappings.put("/purchase/purchase", new ForwardController("/purchase/purchasePage.jsp"));  // 주문하기
        mappings.put("/purchase/purchaseUpdate", new ForwardController("/purchase/purchaseUpdatePage.jsp"));  // 주문하기
        mappings.put("/purchase/purchaseList", new ForwardController("/purchase/orderListPage.jsp"));
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}