package model.dao;

import model.domain.Review;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ReviewDAO {
	private JDBCUtil jdbcUtil = null;
	
	public ReviewDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}

	public Review findReview(int reviewId) throws SQLException {		
		StringBuffer query = new StringBuffer();
		query.append("SELECT reviewid, productid, userid, date, rating, reviewtext, reviewimg ");
		query.append("FROM MEAL_REVIEW ");
		query.append("WHERE reviewId=?");  
		jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {reviewId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// review 정보 발견
				Review review = new Review(		// review 객체를 생성하여 리뷰 정보를 저장
					rs.getInt("reviewid"),
					rs.getInt("productid"),
					rs.getString("userid"),
					rs.getString("date"),
					rs.getDouble("rating"),
					rs.getString("reviewtext"),
					rs.getString("reviewimg"));
				return review;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	// 미완성
	private List<Review> reviewList = new ArrayList<>();
	private List<Review> reviews = new ArrayList<>();
	
    // 리뷰 생성
    public boolean create(Review review) {
        // 데이터베이스에 리뷰를 추가하는 로직
    	StringBuffer query = new StringBuffer();
		query.append("INSERT INTO MEAL_REVIEW (productId, nickname, reviewCreateDat rating, reviewText, reviewImg) VALUE (?, ?, SYSDATE, ?, ?,  ?)");
		Object[] newReview = new Object[] {review.getProductId(), review.getNickname(), review.getRating(), review.getReviewText(), review.getReviewImg()};
		jdbcUtil.setSqlAndParameters(query.toString(), newReview);
		
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return true;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}	
		
        return false;
    }

    public List<Review> findReviewsByProduct(int productId) { // 제품 ID를 기준으로 리뷰 검색 로직 
    	List<Review> result = new ArrayList<>(); 
    	for (Review review : reviewList) { 
    		if (review.getProductId() == (productId)) { 
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
    		existingReview.setReviewText(review.getReviewText()); 
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