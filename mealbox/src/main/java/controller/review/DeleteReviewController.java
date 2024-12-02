package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.service.ReviewManager;

public class DeleteReviewController implements Controller {
    private ReviewManager reviewManager;

    public DeleteReviewController() {
        reviewManager = new ReviewManager();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 삭제할 리뷰 ID 받기
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        
        // 리뷰 삭제
        //boolean isDeleted = reviewManager.deleteReview(reviewId); // 삭제 성공 여부 반환

//        if (isDeleted) {
//            response.setStatus(HttpServletResponse.SC_OK); // 성공 응답 코드
//        } else {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 실패 응답 코드
//        }

        // 리뷰 목록 페이지로 리다이렉트
        return "review/reviewItems";
    }
}