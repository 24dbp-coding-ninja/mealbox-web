package com.example;

import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    private List<Review> reviews;

    public ReviewManager() {
        reviews = new ArrayList<>();
    }

    // 리뷰 추가 메서드
    public void addReview(Review review) {
        reviews.add(review);
    }

    // reviewId로 리뷰 조회 메서드
    public Review getReviewById(int reviewId) {
        for (Review review : reviews) {
            if (review.getReviewId() == reviewId) {
                return review; // 해당 reviewId를 가진 리뷰 반환
            }
        }
        return null; // 리뷰가 없으면 null 반환
    }

    // 모든 리뷰 조회 메서드 (선택적)
    public List<Review> getAllReviews() {
        return reviews;
    }

    // 평균 점수 계산 메서드
    public double calculateAverageScore(String productId) {
        int totalReviews = 0;
        double totalScore = 0.0;

        // 특정 상품에 해당하는 리뷰들만 평점 합산
        for (Review review : reviews) {
            if (review.getProductId().equals(productId)) {
                totalScore += review.getRating().getScore(); // Rating 객체에서 평점 가져옴
                totalReviews++;
            }
        }

        // 평균 평점 계산
        return totalReviews > 0 ? totalScore / totalReviews : 0.0;
    }
}