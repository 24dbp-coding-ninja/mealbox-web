package model.dao;

import java.sql.*;
import java.util.*;
import model.domain.*;
import model.dao.*;
import model.service.*;
import model.service.UserNotFoundException;

public class reviewTest {
	
	//Review부분 테스트
	private static ReviewDAO reviewDao = new ReviewDAO();
	
	public static void main(String[] args) {
		System.out.println("Review 읽기 Test용 코드입니다.");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하시오: ");
        int reviewId = sc.nextInt();
        System.out.println();
        boolean what = reviewDao.delete(reviewId);
        System.out.println(what);
	    
		/*
		try {
	        System.out.print("아이디를 입력하시오: ");
	        int reviewId = sc.nextInt();
	        System.out.println();
	        Review review = reviewDao.findReview(reviewId);
	        if(review != null) {
	            System.out.println("review 정보");
	            System.out.println(review.getReviewId());
	            System.out.println(review.getProductId());
	            System.out.println(review.getNickname());
	            System.out.println(review.getDate());
	            System.out.println(review.getRating());
	            System.out.println(review.getReviewText());
	            System.out.println(review.getReviewImg());
	        } else {
	            System.out.println("리뷰가 없습니다.");
	        }
	    } catch (SQLException e) {
	        System.out.println("데이터베이스 오류: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        sc.close();  // Scanner 리소스 반환
	    }		
		//읽기 테스트 완료
		 */
		
//		System.out.println("\nreview 생성 Test용 코드입니다.");
//        Review review = new Review();
//        review.setProductId(1010);
//        review.setOrderId(1270);
//        review.setLineNo(1470);
//        review.setNickname("id3");
//        review.setRating(Double.parseDouble("2"));
//        review.setReviewText("만들기 어렵당!");
//        review.setReviewImg("review3.jpg");
//        
//        boolean result = reviewDao.create(review);
//        if(result) {
//           System.out.println("생성되었습니다.");
//        }	
		//생성 테스트 완료
	}
}