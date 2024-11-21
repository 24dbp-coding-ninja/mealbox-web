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
		return productDao.getDetail(id);
	}
	
	public List<Product> findProductList() {
		return productDao.getAllProducts();
	}
	
	public int createProduct(Product product) {
		return productDao.create(product);
	}
	
	public int updateProduct(Product product) {
		// TODO : 구현 
		return 0;
	}
	
	public int removeProduct(String productId) {
		// TODO : 구현 
		return 0;
	}
	
	public List<Product> searchProduct(String categoryType, String categoryValue, String orderBy) {
		return productDao.searchProduct(categoryType, categoryValue, orderBy);
	}
	
//	 public int getPurchaseTotalPrice(productDetail) {
//	 }
//
//	 
//	 public void updateItemQuantity(productDetail, String, int) {
//	 }
}