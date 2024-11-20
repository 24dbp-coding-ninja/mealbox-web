package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.domain.Product;

public class ProductDAO {
	private JDBCUtil jdbcUtil = null;

	public ProductDAO() {
		jdbcUtil = new JDBCUtil();
	}

	private static String query = "SELECT productId, productName, productImage, description, price, totalReview, averageReviewScore, stock, personTypeCategory, foodTypeCategory ";

	public int create(Product product) {	
		int result = 0;
		String insertQuery = "INSERT INTO MEAL_PRODUCT VALUES (Sequence_productId.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE)";
		Object[] param = new Object[] {
				product.getName(), product.getThumb(), product.getDescription(), 
				product.getPrice(), product.getStock(), product.getTotalReview(), product.getAverageReview(),
				product.getCategoryPerson(), product.getCategoryType(), 
		};
		jdbcUtil.setSqlAndParameters(insertQuery, param);

		try {
			result = jdbcUtil.executeUpdate();
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return result;
	}

	public int update(Product product) {
		int result = 0;
		String updateQuery = "UPDATE MEAL_PRODUCT "
				+ "SET productName=?, productImage=?, description=?, price=?, stock=?, personTypeCategory=?, foodTypeCategory=?, productUpdatedAt=SYSDATE "
				+ "WHERE productId=?";
		Object[] param = new Object[] {
			product.getName(), product.getThumb(), product.getDescription(), product.getPrice(), product.getStock(), product.getCategoryPerson(), product.getCategoryType(), product.getId() 
		};
		jdbcUtil.setSqlAndParameters(updateQuery, param);

		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	public int delete(int id) {
		String deleteQuery = "DELETE FROM MEAL_PRODUCT WHERE productId=?";		
		jdbcUtil.setSqlAndParameters(deleteQuery, new Object[] {id});

		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}		
		return 0;
	}

	public Product getDetail(int id) {
		String searchQuery = query + "FROM MEAL_PRODUCT " + "WHERE productId = ? "; 
		Object[] param = new Object[] {id};
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			Product prd = null;

			if(rs.next()) {
				prd = new Product(
						rs.getInt("productId"),
						rs.getString("productName"),
						rs.getString("productImage"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("totalReview"),
						rs.getDouble("averageReviewScore"),
						rs.getInt("stock"),
						rs.getInt("personTypeCategory"),
						rs.getInt("foodTypeCategory")
						);
			}
			return prd;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Product> getAllProducts() {
		String allQuery = query + "FROM MEAL_PRODUCT ORDER BY productId ASC"; 
		jdbcUtil.setSqlAndParameters(allQuery, null);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> list = new ArrayList<Product>();

			while(rs.next()) {
				Product prd = new Product(
						rs.getInt("productId"),
						rs.getString("productName"),
						rs.getString("productImage"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("totalReview"),
						rs.getDouble("averageReviewScore"),
						rs.getInt("stock"),
						rs.getInt("personTypeCategory"),
						rs.getInt("foodTypeCategory")
						);
				list.add(prd);
			}
			return list;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}


	public List<Product> searchProductByName(String name) {
		String searchQuery = query + "FROM MEAL_PRODUCT " + "WHERE productName LIKE ?";
		Object[] param = new Object[] {"%" + name + "%"};
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> list = new ArrayList<Product>();

			while(rs.next()) {
				Product prd = new Product(
						rs.getInt("productId"),
						rs.getString("productName"),
						rs.getString("productImage"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("totalReview"),
						rs.getDouble("averageReviewScore"),
						rs.getInt("stock"),
						rs.getInt("personTypeCategory"),
						rs.getInt("foodTypeCategory")
						);
				list.add(prd);
			}
			return list;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Product> searchByCategoryPerson(String person) {
		String searchQuery = query + "FROM MEAL_PRODUCT " + "WHERE personTypeCategory = ? "; 
		Object[] param = new Object[] {person};
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> list = new ArrayList<Product>();

			if(rs.next()) {
				Product prd = new Product(
						rs.getInt("productId"),
						rs.getString("productName"),
						rs.getString("productImage"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("totalReview"),
						rs.getDouble("averageReviewScore"),
						rs.getInt("stock"),
						rs.getInt("personTypeCategory"),
						rs.getInt("foodTypeCategory")
						);
				list.add(prd);
			}
			return list;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Product> searchByCategoryType(String type) {
		String searchQuery = query + "FROM MEAL_PRODUCT " + "WHERE foodTypeCategory = ? "; 
		Object[] param = new Object[] {type};
		jdbcUtil.setSqlAndParameters(searchQuery, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<Product> list = new ArrayList<Product>();

			if(rs.next()) {
				Product prd = new Product(
						rs.getInt("productId"),
						rs.getString("productName"),
						rs.getString("productImage"),
						rs.getString("description"),
						rs.getInt("price"),
						rs.getInt("totalReview"),
						rs.getDouble("averageReviewScore"),
						rs.getInt("stock"),
						rs.getInt("personTypeCategory"),
						rs.getInt("foodTypeCategory")
						);
				list.add(prd);
			}
			return list;
		} catch(Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}

	public List<Product> orderBy(String type) {
		switch(type) {
		// 최신등록순
		case "1":
		    
		    break;
		
		// 낮은가격순
		case "2":
		    break;
		    
		// 높은가격순
		case "3":
		    break;
            
		// 평점높은순
        case "4":
            break;
		}
	    
	    
		return null;
	}


}