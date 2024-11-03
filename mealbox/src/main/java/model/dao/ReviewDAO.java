package model.dao;

import model.domain.Review;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
	private List<Review> reviewList = new ArrayList<>();
	private List<Review> reviews = new ArrayList<>();
	
    // 리뷰 생성
    public boolean create(Review review) {
        // 데이터베이스에 리뷰를 추가하는 로직
    	return reviews.add(review);
        //return true;
    }

    public List<Review> findReviewsByProduct(int productId) { // 제품 ID를 기준으로 리뷰 검색 로직 
    	List<Review> result = new ArrayList<>(); 
    	for (Review review : reviewList) { 
    		if (review.getProductId().equals(productId)) { 
    			result.add(review); 
    		} 
    	} 
    	return result; 
    }
    // 특정 제품의 리뷰 조회
//    public List<Review> findReviewsByProduct(String productId) {
//        // 데이터베이스에서 특정 제품의 리뷰를 조회하는 로직
//    	List<Review> result = new ArrayList<>();
//    	for (Review review : reviews) { 
//    		if (review.getProductId().equals(productId)) { 
//    			result.add(review);
//    		}
//    	}
//    	return result;
//    	//return null;
//    }

    public List<Review> findReviewsByMyPage(int reviewId) { // 리뷰 ID를 기준으로 리뷰 검색 로직 
    	List<Review> result = new ArrayList<>(); 
    	for (Review review : reviewList) { 
    		if (review.getReviewId() == reviewId) { 
    			result.add(review); 
    		} 
    	} 
    	return result; 
    }

    // 리뷰 수정
    public boolean update(Review review) {
        // 데이터베이스에서 리뷰를 수정하는 로직
    	Review existingReview = findById(review.getReviewId()); 
    	if (existingReview != null) { 
    		existingReview.setRating(review.getRating()); 
    		existingReview.setText(review.getText()); 
    		existingReview.setReviewImg(review.getReviewImg()); 
    		return true;
    	} 
    	return false;
    	//return true;
    }
//    public boolean update(Review review) { // 리뷰 업데이트 로직 
//    	int index = reviewList.indexOf(review); 
//    	if (index != -1) { 
//    		reviewList.set(index, review); 
//    		return true; 
//    	} 
//    	return false;
//    }

    // 리뷰 삭제
//    public boolean delete(int reviewId) {
//        // 데이터베이스에서 리뷰를 삭제하는 로직
//    	Review review = findById(reviewId);
//    	return reviews.remove(review);
//        //return true;
//    }
    public boolean delete(int reviewId) { // 리뷰 삭제 로직 
    	return reviewList.removeIf(review -> review.getReviewId() == reviewId);
    }
    
    public Review findById(int reviewId) { 
    	for (Review review : reviews) { 
    		if (review.getReviewId() == reviewId) { 
    			return review; 
    		} 
    	}
    	return null;
    }
}