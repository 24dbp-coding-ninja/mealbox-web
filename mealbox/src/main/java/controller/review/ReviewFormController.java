package controller.review;

import model.service.ProductManager;
import model.service.ReviewManager;
import model.domain.Product;
import model.domain.Review;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.user.UserSessionUtils;

public class ReviewFormController implements Controller {
    private ReviewManager reviewManager;

    public ReviewFormController() {
        reviewManager = new ReviewManager();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {        
//    	int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        //int productId = 1010;//Integer.parseInt(request.getParameter("productId"));
    	int productId = Integer.parseInt(request.getParameter("productId"));
        
    	ProductManager manager = ProductManager.getInstance();
        Product product = manager.getDetail(productId);
        request.setAttribute("product", product);
        //System.out.println(productId);
        
		return "/review/reviewForm.jsp";
    }
}