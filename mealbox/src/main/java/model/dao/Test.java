package model.dao;

import java.sql.*;
import java.util.*;
import model.domain.*;
import model.service.*;
import model.service.UserNotFoundException;

public class Test {
	
	//User부분 테스트
	private static UserDAO userDao = new UserDAO();
	
	public static void main(String[] args) {
		System.out.println("Test용 코드입니다.");
		Scanner sc = new Scanner(System.in);
		
		
		try {
	        System.out.print("아이디를 입력하시오: ");
	        String userId = sc.next();
	        System.out.println();
	        User user = userDao.findUser(userId);
	        if(user != null) {
	            System.out.println("user정보");
	            System.out.println(user.getId());
	            System.out.println(user.getPassword());
	            System.out.println(user.getName());
	            System.out.println(user.getPhone());
	            System.out.println(user.getEmail());
	            System.out.println(user.getAddress());
	        } else {
	            System.out.println("회원정보가 없습니다.");
	        }
	    } catch (SQLException e) {
	        System.out.println("데이터베이스 오류: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        sc.close();  // Scanner 리소스 반환
	    }
		
		//User부분 테스트 완료

	}
}