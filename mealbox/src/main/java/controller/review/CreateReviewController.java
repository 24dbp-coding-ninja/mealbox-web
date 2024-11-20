package controller.review;

import model.service.ReviewManager;
import model.domain.Review;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;

public class CreateReviewController implements Controller {
    private ReviewManager reviewManager;

    public CreateReviewController() {
        reviewManager = new ReviewManager();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        String nickname = request.getParameter("nickname");
        String date = request.getParameter("date");
        double rating = Double.parseDouble(request.getParameter("rating"));
        String reviewText = request.getParameter("reviewText");
        String reviewImg = request.getParameter("reviewImg");

        Review newReview = new Review(reviewId, productId, nickname, date, rating, reviewText, reviewImg);
        boolean createResult = reviewManager.createReview(newReview);

        if (createResult) {
            return "redirect:/purchase/orderListPage";
        } else {
            request.setAttribute("createResult", createResult);
            return "/review/reviewForm.jsp";
        }
    }
}