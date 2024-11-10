/*
기능: OrderDAO
작성자: 장고은
마지막 수정일: 2024-11-10
*/

package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.Order;

/**
 * 주문 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * MEAL_ORDER 테이블에서 주문 정보를 추가, 수정, 삭제 수행 (검색은 추후에 추가될 수 있으므로 추가함) 
 */
public class OrderDAO {
	private JDBCUtil jdbcUtil = null;
	
	public OrderDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	/**
	 * MEAL_ORDER 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	*/
	public int create(Order order) throws SQLException {
		String sql = "INSERT INTO MEAL_ORDER VALUES (Sequence_orderId.nextval, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {order.getUserId(), order.getOrderAt(), order.getPurchaser(), order.getPurPhone(), 
							order.getRecipient(), order.getRecPhone(), order.getDeliveryAddress(), order.getTotalPrice(), order.getDeliveryDate()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;				
	}
	
	/**
	 * 기존 주문 정보를 수정.
	 */
	public int update(Order order) throws SQLException {
		String sql = "UPDATE MEAL_ORDER "
					+ "SET userId=?, orderAt=?, purchaser=?, purPhone=?, recipient=?, recPhone=?, deliveryAddress=?, totalPrice=?, deliveryDate=? "
					+ "WHERE orderId=?";
		Object[] param = new Object[] {order.getUserId(), order.getOrderAt(), order.getPurchaser(), order.getPurPhone(), 
				order.getRecipient(), order.getRecPhone(), order.getDeliveryAddress(), 
				order.getTotalPrice(), order.getDeliveryDate()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/**
	 * 주어진 ID에 해당하는 주문 정보를 삭제.
	 */
	public int remove(int orderId) throws SQLException {
		String sql = "DELETE FROM MEAL_ORDER WHERE orderId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {orderId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/**
	 * 주어진 주문 ID에 해당하는 주문 정보를 데이터베이스에서 찾아 Order 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public Order findOrder (int orderId) throws SQLException {
        String sql = "SELECT userId, orderAt, purchaser, purPhone, recipient, recPhone, deliveryAddress, totalPrice, deliveryDate "
        			+ "FROM MEAL_ORDER o LEFT OUTER JOIN MEAL_USER u ON o.userId = u.userId "
        			+ "WHERE orderId=?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {orderId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 주문 정보 발견
				Order order = new Order(		// Order 객체를 생성하여 주문 정보를 저장
					orderId,
					rs.getInt("userId"),
					rs.getDate("orderAt"),
					rs.getString("purchaser"),
					rs.getString("purPhone"),
					rs.getString("recipient"),					
					rs.getString("recPhone"),
					rs.getString("deliveryAddress"),
					rs.getInt("totalPrice"),		
					rs.getDate("deliveryDate"));		
				return order;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 주문 정보를 검색하여 List에 저장 및 반환
	 */
	public List<Order> findOrderList() throws SQLException {
        String sql = "SELECT orderId, userId, orderAt, purchaser, purPhone, recipient, recPhone, deliveryAddress, totalPrice, deliveryDate " 
        		   + "FROM MEAL_ORDER o LEFT OUTER JOIN MEAL_USER u ON o.userId = u.userId "
        		   + "ORDER BY orderId";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<Order> orderList = new ArrayList<Order>();	// Order들의 리스트 생성
			while (rs.next()) {
				Order order = new Order(			// Order 객체를 생성하여 현재 행의 정보를 저장
					rs.getInt("orderId"),
					rs.getInt("userId"),
					rs.getDate("orderAt"),
					rs.getString("purchaser"),
					rs.getString("purPhone"),
					rs.getString("recipient"),					
					rs.getString("recPhone"),
					rs.getString("deliveryAddress"),
					rs.getInt("totalPrice"),		
					rs.getDate("deliveryDate"));	
				orderList.add(order);				// List에 Order 객체 저장
			}		
			return orderList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 주문 정보를 검색한 후 현재 페이지와 페이지당 출력할 주문 수를 이용하여
	 * 해당하는 주문 정보만을 List에 저장하여 반환.
	 * 프로젝트에는 포함되지 않는 기능
	 * 이후 추가될 수 있음
	 */
	public List<Order> findOrderList(int currentPage, int countPerPage) throws SQLException {
		String sql = "SELECT orderId, userId, orderAt, purchaser, purPhone, recipient, recPhone, deliveryAddress, totalPrice, deliveryDate " 
     		   + "FROM MEAL_ORDER o LEFT OUTER JOIN MEAL_USER u ON o.userId = u.userId "
     		   + "ORDER BY orderId";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<Order> orderList = new ArrayList<Order>();	// Order들의 리스트 생성
				do {
					Order order = new Order(			// Order 객체를 생성하여 현재 행의 정보를 저장
							rs.getInt("orderId"),
							rs.getInt("userId"),
							rs.getDate("orderAt"),
							rs.getString("purchaser"),
							rs.getString("purPhone"),
							rs.getString("recipient"),					
							rs.getString("recPhone"),
							rs.getString("deliveryAddress"),
							rs.getInt("totalPrice"),		
							rs.getDate("deliveryDate"));
					orderList.add(order);							// List에 Order 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return orderList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 특정 사용자가 주문한 주문 정보들을 검색하여 List에 저장 및 반환
	 * 프로젝트에는 포함되지 않는 기능
	 * 이후 추가될 수 있음
	 */
	public List<Order> findOrdersInUser(int userId) throws SQLException {
        String sql = "SELECT orderId, orderAt, purchaser, purPhone, recipient, recPhone, deliveryAddress, totalPrice, deliveryDate " 
      		   + "FROM MEAL_ORDER o LEFT OUTER JOIN MEAL_USER u ON o.userId = u.userId "
      		   + "ORDER BY orderId "
      		   + "WHERE userId = ?";                          
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<Order> orderList = new ArrayList<Order>();	// 주문들의 리스트 생성
			while (rs.next()) {
				Order order = new Order(			// Order 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("orderId"),
						rs.getDate("orderAt"),
						rs.getString("purchaser"),
						rs.getString("purPhone"),
						rs.getString("recipient"),					
						rs.getString("recPhone"),
						rs.getString("deliveryAddress"),
						rs.getInt("totalPrice"),		
						rs.getDate("deliveryDate"));
				orderList.add(order);			// List에 Order 객체 저장
			}		
			return orderList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}
