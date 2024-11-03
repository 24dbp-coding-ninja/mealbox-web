// ReviewServlet.java (서블릿)
package model.domain;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import model.dao.ReviewManager; // ReviewManager 클래스를 import
import model.domain.Review; // Review 클래스를 import

public class ReviewServlet extends HttpServlet {
    private ReviewManager reviewManager; // ReviewManager 인스턴스 생성

    @Override
    public void init() {
        reviewManager = new ReviewManager();
        
        // 초기 데이터 추가 (예시)
        reviewManager.addReview(new Review("gobdoritang", "a", "../img/gobdoritang.png", "2024-09-25", "⭐️⭐️⭐️⭐️", 4.0, "진짜 너무 너무 맛있어요!", "맛있딜리, 색색브리 (7개)", "../img/gobdoritang.png"));
        // 추가적인 리뷰들...
        // reviews.add(new Review("gobdoritang", "b", "../img/gobdoritang.png", "2024-09-24", "⭐️⭐️⭐️⭐️⭐️", 5.0, "좋은 맛이었어요! 하지만 조금 비쌌어요.", "맛있딜리, 초코브리 (5개)", "../img/gobdoritang.png"));
        // reviews.add(new Review("gobdoritang", "c", "../img/gobdoritang.png", "2024-09-23", "⭐️⭐️⭐️",  3.0, "괜찮은 맛, 하지만 기대에 미치지 못했어요.", "맛있딜리, 과일브리 (6개)", "../img/gobdoritang.png"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
        // 모든 리뷰 가져오기
        List<Review> reviews = reviewManager.getAllReviews();

        // 정렬 기준을 파라미터로 받음
        String sortStandard = request.getParameter("sort");

        // 정렬 기준에 따라 리뷰 리스트를 정렬
        if ("latest".equals(sortStandard)) {
            reviews.sort(Comparator.comparing(Review::getDate).reversed()); // 최신순 정렬
        } else if ("highRate".equals(sortStandard)) {
            //reviews.sort(Comparator.comparing(Review::getRating).reversed()); // 평점 높은순 정렬
        	reviews.sort(Comparator.comparing((Review r) -> r.getRating().getScore()).reversed()); // 평점 높은순 정렬
        } else if ("lowRate".equals(sortStandard)) {
            //reviews.sort(Comparator.comparing(Review::getRating)); // 평점 낮은순 정렬
        	reviews.sort(Comparator.comparing((Review r) -> r.getRating().getScore())); // 평점 낮은순 정렬 }
        }
        
        request.setAttribute("reviews", reviews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reviews.jsp");
        dispatcher.forward(request, response);

        String productId = request.getParameter("productId"); // 클라이언트에서 상품 ID 받기
        double averageScore = reviewManager.calculateAverageScore(productId); // 상품에 대한 평균 평점 계산
        
        // JSON 형태로 평균 평점 응답
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String jsonResponse = String.format("{\"averageScore\": %.1f}", averageScore);
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 리뷰 데이터 받기
        String productId = request.getParameter("productId");
        String nickname = request.getParameter("nickname");
        String profile = request.getParameter("profile");
        String date = request.getParameter("date");
        String stars = request.getParameter("stars"); // 별점 텍스트로 받기
        int rating = Integer.parseInt(request.getParameter("rating"));
        String text = request.getParameter("text");
        String product = request.getParameter("product");
        String reviewImg = request.getParameter("reviewImg");

        // 새로운 리뷰 생성
        Review newReview = new Review(productId, nickname, profile, date, stars, rating, text, product, reviewImg);
        
        // 리뷰 매니저에 리뷰 추가
        reviewManager.addReview(newReview);

        // 리뷰 목록 페이지로 리다이렉트
        response.sendRedirect("ReviewServlet");
    }
}