package controller.review;

import model.dao.ReviewManager;
import model.domain.Review;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.Comparator;
import controller.Controller;

public class ReadReviewController implements Controller {
    private ReviewManager reviewManager;

    public ReadReviewController() {
        reviewManager = new ReviewManager();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Review> reviews = reviewManager.getAllReviews();
        String sortStandard = request.getParameter("sort");

        if ("latest".equals(sortStandard)) {
            reviews.sort(Comparator.comparing(Review::getDate).reversed());
        } else if ("highRate".equals(sortStandard)) {
            reviews.sort(Comparator.comparing((Review r) -> r.getRating().getScore()).reversed());
        } else if ("lowRate".equals(sortStandard)) {
            reviews.sort(Comparator.comparing((Review r) -> r.getRating().getScore()));
        }

        request.setAttribute("reviews", reviews);
        return "/review/reviewItems.jsp";
    }
}