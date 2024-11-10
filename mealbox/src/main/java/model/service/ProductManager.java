package model.service;

import model.domain.Product;
import java.util.List;
import model.dao.ProductDAO;

public class ProductManager {
	
	private static ProductManager productMan = new ProductManager();
	private ProductDAO productDao;
	
	private ProductManager() {
		try {
			productDao = new ProductDAO();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProductManager getInstance() {
		return productMan;
	}
	
	public Product getDetail(int id) {
		// TODO : 구현 
		return null;
	}
	
	public List<Product> findProductList() {
		// TODO : 구현 
		return null;
	}
	
	public int createProduct(Product product) {
		// TODO : 구현 
		return 0;
	}
	
	public int updateProduct(Product product) {
		// TODO : 구현 
		return 0;
	}
	
	public int removeProduct(String productId) {
		// TODO : 구현 
		return 0;
	}
	
	public List<Product> searchProduct(String keyword) {
		// TODO : 구현 
		return null;
	}

	public List<Product> searchProductByCategoryType(String categoryType) {
		// TODO : 구현 
		return null;
	}

	public List<Product> searchProductByCategoryPerson(String personType) {
		// TODO : 구현 
		return null;
	}

	public List<Product> orderBy(String order) {
		// TODO : 구현 
		return null;
	}
	
//	 public int getPurchaseTotalPrice(productDetail) {
//	 }
//
//	 
//	 public void updateItemQuantity(productDetail, String, int) {
//	 }
}