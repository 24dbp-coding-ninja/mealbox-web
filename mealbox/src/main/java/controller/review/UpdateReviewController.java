package controller.review;

import model.service.ReviewManager;
import model.domain.Review;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;

public class UpdateReviewController implements Controller {
    private ReviewManager reviewManager;

    public UpdateReviewController() {
        reviewManager = new ReviewManager();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        Review review = reviewManager.getReviewById(reviewId);

        if (review != null) {
            review.setProductId(request.getParameter("productId"));
            review.setNickname(request.getParameter("nickname"));
            review.setDate(request.getParameter("date"));
            review.setRating(Double.parseDouble(request.getParameter("rating")));
            review.setReviewText(request.getParameter("text"));
            review.setReviewImg(request.getParameter("reviewImg"));
        }

        return "redirect:/review/reviewItems.jsp";
    }
}