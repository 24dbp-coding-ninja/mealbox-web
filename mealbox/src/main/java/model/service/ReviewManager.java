package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.CommunityDAO;
import model.dao.ReviewDAO;
import model.domain.Community;
import model.domain.User;
import model.domain.Review;
import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    private static ReviewManager userMan = new ReviewManager();
	private ReviewDAO reviewDAO;

	public ReviewManager() {
		try {
			reviewDAO = new ReviewDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	// private ReviewDAO reviewDAO;
    private List<Review> reviews;

//    public ReviewManager() {
//        reviews = new ArrayList<>();
//    }

    // 리뷰 추가 메서드
    public void addReview(Review review) {
        reviews.add(review);
    }

    // 리뷰 생성 메서드 추가
    public boolean createReview(Review review) { 
    	return reviewDAO.create(review);
    }

    // reviewId로 리뷰 조회 메서드
    public Review getReviewById(int reviewId) {
        for (Review review : reviews) {
            if (review.getReviewId() == reviewId) {
                return review;
            }
        }
        return null;
    }

    // 특정 상품의 리뷰 조회 메서드
    public List<Review> findReviewsByProduct(int productId) { 
    	return reviewDAO.findReviewsByProduct(productId); 
    }
    
    public List<Review> findReviewsByMyPage(int reviewId) { 
    	return reviewDAO.findReviewsByMyPage(reviewId); 
    }

    // 모든 리뷰 조회 메서드
    public List<Review> getAllReviews() {
        return reviews;
    }

    public boolean updateReview(Review review) { 
    	return reviewDAO.update(review);
    }
    
    // 리뷰 삭제 메서드 추가
//    public boolean deleteReviewById(int reviewId) {
//        Review review = getReviewById(reviewId);
//        if (review != null) {
//            return reviews.remove(review);
//        }
//        return false;
//    }
    public boolean deleteReview(int reviewId) { 
    	return reviewDAO.delete(reviewId);
    }

    // 평균 점수 계산 메서드
    public double calculateAverageScore(int productId) {
        int totalReviews = 0;
        double totalScore = 0.0;

        for (Review review : reviews) {
            if (review.getProductId() == productId) {
                totalScore += review.getRating();
                totalReviews++;
            }
        }
        return totalReviews > 0 ? totalScore / totalReviews : 0.0;
    }
}