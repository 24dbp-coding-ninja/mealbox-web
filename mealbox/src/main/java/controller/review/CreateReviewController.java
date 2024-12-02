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

public class CreateReviewController implements Controller {
    private ReviewManager reviewManager;

    public CreateReviewController() {
        reviewManager = new ReviewManager();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	int orderId = Integer.parseInt(request.getAttribute(orderId));
    	request.setAttribute("orderId", orderId);
    	
    	String btnName = request.getParameter("btnName");
    	
    	if ("save".equals(btnName)) {
//        	int reviewId = Integer.parseInt(request.getParameter("reviewId"));

        	int productId = Integer.parseInt(request.getParameter("productId")); // int productId = 1010;
         
//            String nickname = request.getParameter("nickname");
            HttpSession session = request.getSession();
        	String nickname = (String)session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
        	
//            String date = request.getParameter("date");
            double rating = Double.parseDouble(request.getParameter("rating"));
            String reviewText = request.getParameter("reviewText");
            String reviewImg = "example.jpg";//request.getParameter("reviewImg");

            Review newReview = new Review(productId, nickname, rating, reviewText, reviewImg);
            boolean createResult = reviewManager.createReview(newReview);

            if (createResult) {
                return "redirect:/purchase/purchaseList/orderId";
            } else {
                request.setAttribute("createResult", createResult);
                return "/review/reviewForm.jsp";
            }
    	}
    	return "redirect:/purchase/purchaseList/orderId";
    }
}