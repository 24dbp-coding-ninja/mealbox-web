package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.domain.Community;
import model.domain.User;
import model.service.UserManager;

public class UpdateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	UserManager manager = UserManager.getInstance();

    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		/*String updateId = request.getParameter("userId");

    		log.debug("UpdateForm Request : {}", updateId);
    		
			User user = manager.findUser(updateId);	// 수정하려는 사용자 정보 검색
			request.setAttribute("user", user);			
			
			if (UserSessionUtils.isLoginUser(updateId, session) ||
				UserSessionUtils.isLoginUser("admin", session)) {
				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
				return "/user/updatePage.jsp"; 
			// else (수정 불가능한 경우) 사용자 보기 화면으로 오류 메세지를 전달
			request.setAttribute("updateFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("타인의 정보는 수정할 수 없습니다."));            
			return "redirect:/main";
			}
			*/
    		
    		//나중에 adminUser에서 수정할 때를 고려하여, 현재 접속한 id를 loginId로 저장함.
			HttpSession session = request.getSession();
			String loginId = (String)session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
			User user = manager.findUser(loginId);
			request.setAttribute("user", user);
			
			return "/user/updatePage.jsp";
	    }	
    	
    	// POST request (회원정보가 parameter로 전송됨)
    	User updateUser = new User(
    			request.getParameter("id"),
    			request.getParameter("password"),
    			request.getParameter("name"),
    			request.getParameter("phone_part1") + "-" +request.getParameter("phone_part2") + "-" +request.getParameter("phone_part3"),
    			request.getParameter("email_id") + "@" +request.getParameter("email_domain"),
    			request.getParameter("address"));
		
    	log.debug("Update User : {}", updateUser);

		manager.update(updateUser);			
        return "redirect:/user/readUser";			
    }
}