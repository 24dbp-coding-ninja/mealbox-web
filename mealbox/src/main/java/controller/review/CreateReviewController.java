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
//        	int reviewId = Integer.parseInt(request.getParameter("reviewId"));
//        	System.out.println("\n\n reviewId==="+reviewId);
        	
        	int productId = Integer.parseInt(request.getParameter("productId")); // int productId = 1010;
        	ProductManager manager = ProductManager.getInstance();
            Product product = manager.getDetail(productId);
            request.setAttribute("product", product);
        	System.out.println("\n productId==="+productId);
        	int orderId = Integer.parseInt(request.getParameter("orderId"));
        	System.out.println("\n orderId==="+orderId);
        	int lineNo = Integer.parseInt(request.getParameter("lineNo"));
        	System.out.println("\n lineNo==="+lineNo);

			System.out.println("Logged-in OrderId ID: " + orderId);
            HttpSession session = request.getSession();
        	String nickname = (String)session.getAttribute(UserSessionUtils.USER_SESSION_KEY); // request.getParameter("nickname");
        	
//            String date = request.getParameter("date");
            double rating = Double.parseDouble(request.getParameter("rating"));
            String reviewText = request.getParameter("reviewText");
            String reviewImg = "example.jpg";//request.getParameter("reviewImg");

            
            // 기존 리뷰 확인
            int reviewId = reviewManager.findReviewId(productId, orderId);
            boolean isUpdated;
            if (reviewId != 0) {
                // 리뷰가 이미 존재하면 업데이트
                Review existingReview = reviewManager.getReviewById(reviewId);
                existingReview.setRating(rating);
                existingReview.setReviewText(reviewText);
                existingReview.setReviewImg(reviewImg);

                isUpdated = reviewManager.updateReview(existingReview);
            } else {
            	Review newReview = new Review(productId, orderId, lineNo, nickname, rating, reviewText, reviewImg);
                //boolean createResult = reviewManager.createReview(newReview);
                isUpdated = reviewManager.createReview(newReview);
            }
            
//            if (createResult) {
//                return "redirect:/purchase/purchaseList";
//            } else {
//                request.setAttribute("createResult", createResult);
//                return "/review/reviewForm.jsp";
//            }
            if (isUpdated) {
                return "redirect:/purchase/purchaseList";
            } else {
            	request.setAttribute("isUpdated", isUpdated);
                request.setAttribute("errorMessage", "리뷰 저장에 실패했습니다. 다시 시도해 주세요.");
                return "/review/reviewForm.jsp";
            }
    }
}