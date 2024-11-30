package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.domain.Community;
import model.domain.User;
import model.service.ExistingUserException;
import model.service.UserManager;

public class CreateUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(CreateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	UserManager manager = UserManager.getInstance();
    	
    	if (request.getMethod().equals("GET")) {
    		String id = request.getParameter("inputId");
	    	request.setAttribute("idExist", false);
	    	if(manager.getUserDAO().existingUser(id)) {
	    		request.setAttribute("idExist", true);
	    	}
	    	request.setAttribute("inputId", id);
    	return "/user/join.jsp";
    	}
    	// POST request (회원정보가 parameter로 전송됨)
       	User user = new User(
			request.getParameter("id"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("phone_part1") + "-" +request.getParameter("phone_part2") + "-" +request.getParameter("phone_part3"),
			request.getParameter("email_id") + "@" +request.getParameter("email_domain"),
			request.getParameter("address"));
		
        log.debug("Create User : {}", user);

		try {
			manager.create(user);
			request.setAttribute("userName", user.getName());
	        return "/user/joinSuccess.jsp";	// 성공 시 joinSuccess.jsp로 포워딩
	        
		} catch (ExistingUserException e) {	// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("createFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("user", user);
			return "/user/join.jsp";
		}
    }
}

