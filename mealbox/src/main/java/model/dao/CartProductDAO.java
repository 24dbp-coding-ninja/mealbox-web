/*
기능: CartProductDAO
작성자: 장고은
마지막 수정일: 2024-11-10
*/

package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.domain.CartProduct;

/**
 * 장바구니 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * MEAL_CART_PRODUCT 테이블에서 장바구니 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class CartProductDAO {
	private JDBCUtil jdbcUtil = null;
	
	public CartProductDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	/**
	 * MEAL_CART_PRODUCT 테이블에 새로운 행 생성 (PK 값은 Sequence를 이용하여 자동 생성)
	*/
	public int create(CartProduct cartProduct) throws SQLException {
		String sql = "INSERT INTO MEAL_CART_PRODUCT VALUES ?, ?, ?, ?)";		
		Object[] param = new Object[] {cartProduct.getUserId(), cartProduct.getProductId(), cartProduct.getQuantity(), cartProduct.getCartItemPrice()};				
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
	 * 기존 장바구니 상품 정보를 수정.
	 */
	public int update(CartProduct cartProduct) throws SQLException {
		String sql = "UPDATE MEAL_CART_PRODUCT "
					+ "SET quantity=?, cartItemPrice=? "
					+ "WHERE userId=? AND productId=?";
		Object[] param = new Object[] {cartProduct.getQuantity(), cartProduct.getCartItemPrice()};				
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
	 * 주어진 ID에 해당하는 장바구니 상품 정보를 삭제.
	 */
	public int remove(int userId, int productId) throws SQLException {
		String sql = "DELETE FROM MEAL_CART_PRODUCT WHERE userId=? AND productId=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, productId});	// JDBCUtil에 delete문과 매개 변수 설정

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
	 * 특정 사용자가 장바구니에 담은 상품 정보들을 검색하여 List에 저장 및 반환
	 */
	public List<CartProduct> findCartProductInUser(int userId) throws SQLException {
        String sql = "SELECT productId, quantity, cartItemPrice " 
      		   + "FROM MEAL_CART_PRODUCT "
      		   + "ORDER BY productId "
      		   + "WHERE userId = ?";                          
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			List<CartProduct> cartProductList = new ArrayList<CartProduct>();	// 장바구니 상품 정보들의 리스트 생성
			while (rs.next()) {
				CartProduct cartProduct = new CartProduct(			// CartProduct 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("productId"),
						rs.getInt("quantity"),
						rs.getInt("cartItemPrice"));
				cartProductList.add(cartProduct);			// List에 CartProduct 객체 저장
			}		
			return cartProductList;					
				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
}