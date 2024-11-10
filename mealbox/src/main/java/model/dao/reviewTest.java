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
		System.out.println("Review Test용 코드입니다.");
		Scanner sc = new Scanner(System.in);
		
		try {
	        System.out.print("아이디를 입력하시오: ");
	        String reviewId = sc.next();
	        System.out.println();
	        Review review = reviewDao.findReview(reviewId);
	        if(review != null) {
	            System.out.println("review 정보");
	            System.out.println(review.getReviewId());
	            System.out.println(review.getProductId());
	        } else {
	            System.out.println("리뷰가 없습니다.");
	        }
	    } catch (SQLException e) {
	        System.out.println("데이터베이스 오류: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        sc.close();  // Scanner 리소스 반환
	    }
		
		//테스트 완료

	}
}