// ReviewServlet.java (서블릿)
package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("gobdoritang", "a", "../img/gobdoritang.png", "2024-09-25", 4, "진짜 너무 너무 맛있어요!", "맛있딜리, 색색브리 (7개)", "../img/gobdoritang.png"));
        reviews.add(new Review("gobdoritang", "b", "../img/gobdoritang.png", "2024-09-24", 5, "좋은 맛이었어요! 하지만 조금 비쌌어요.", "맛있딜리, 초코브리 (5개)", "../img/gobdoritang.png"));
        reviews.add(new Review("gobdoritang", "c", "../img/gobdoritang.png", "2024-09-23", 3, "괜찮은 맛, 하지만 기대에 미치지 못했어요.", "맛있딜리, 과일브리 (6개)", "../img/gobdoritang.png"));

        // 정렬 기준을 파라미터로 받음
        String sortStandard = request.getParameter("sort");

        // 정렬 기준에 따라 리뷰 리스트를 정렬
        if ("latest".equals(sortStandard)) {
            reviews.sort(Comparator.comparing(Review::getDate).reversed()); // 최신순 정렬
        } else if ("highRate".equals(sortStandard)) {
            reviews.sort(Comparator.comparing(Review::getRating).reversed()); // 평점 높은순 정렬
        } else if ("lowRate".equals(sortStandard)) {
            reviews.sort(Comparator.comparing(Review::getRating)); // 평점 낮은순 정렬
        }
        
        request.setAttribute("reviews", reviews);
        RequestDispatcher dispatcher = request.getRequestDispatcher("reviews.jsp");
        dispatcher.forward(request, response);
    }
}