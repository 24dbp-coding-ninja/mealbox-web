package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.user.*;
import controller.comm.*;
import controller.purchase.*;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/", new ForwardController("index.jsp"));
        //mappings.put("/user/login/form", new ForwardController("/user/login.jsp"));
        //mappings.put("/user/login", new LoginController());
        //mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/view", new ViewUserController());
        
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
//      mappings.put("/user/register", new RegisterUserController());
        //mappings.put("/user/register", new RegisterUserController());

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/delete", new DeleteUserController());
        
        // 커뮤니티 관련 request URI 추가
      //  mappings.put("/community/list", new ListCommunityController());
      //  mappings.put("/community/view", new ViewCommunityController());
       // mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
      //  mappings.put("/community/create", new CreateCommunityController());
      //  mappings.put("/community/update", new UpdateCommunityController());
        
        
        // 여기서부터 코드닌자 코드 추가
        //영선-로그인, 회원가입, adminUserPage
        mappings.put("/user/login/form", new ForwardController("/user/login.jsp"));
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/join/form", new ForwardController("/user/join.jsp"));
        mappings.put("/user/join", new CreateUserController());
        mappings.put("/user/joinSuccess/form", new ForwardController("/user/joinSuccess.jsp"));
        mappings.put("/user/readUser", new ForwardController("/user/updatePage.jsp"));
        mappings.put("/user/listUser", new ListUserController());
        
        // 고은 -myPage
        mappings.put("/user/readUser", new ForwardController("/user/myPage.jsp"));

        //고은-주문내역, 장바구니
        mappings.put("/cart/cartList",new ForwardController("/cart/cartPage.jsp"));
        mappings.put("/purchase/purchaseList", new ForwardController("/purchase/orderListPage.jsp"));

        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}