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
        String productId = request.getParameter("productId");
        String nickname = request.getParameter("nickname");
        String profile = request.getParameter("profile");
        String date = request.getParameter("date");
        double rating = Double.parseDouble(request.getParameter("rating"));
        String text = request.getParameter("text");
        String product = request.getParameter("product");
        String reviewImg = request.getParameter("reviewImg");

        Review newReview = new Review(productId, nickname, profile, date, rating, text, product, reviewImg);
        boolean createResult = reviewManager.createReview(newReview);

        if (createResult) {
            return "redirect:/purchase/orderListPage";
        } else {
            request.setAttribute("createResult", createResult);
            return "forward:/review/reviewItems.jsp";
        }
    }
}