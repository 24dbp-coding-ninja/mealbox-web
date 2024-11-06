/*
기능: Product
작성자: 신윤
마지막 수정일: 2024-10-05
추가해야할 기능: 페이지 이동
*/

package model.domain;

public class Product {
	private int id;
	private String name;
	private String thumb;
	private String description;
	private int price;
	private int totalReview;
	private double averageReview;
	private int stock;
	private String categoryPerson;
	private String categoryType;
	

//	public Product(int id, String name, String thumb, String description, int price, int totalReview, double averageReview, int stock, String categoryPerson, String categoryType) {
//		this.id = id;
//		this.name = name;
//		this.thumb = thumb;
//		this.description = description;
//		this.price = price;
//		this.totalReview = totalReview;
//		this.averageReview = averageReview;
//		this.stock = stock;
//		this.categoryPerson = categoryPerson;
//		this.categoryType = categoryType;
//	}

	public Product(String name, String thumb, String description, int price, int totalReview, double averageReview, int stock, String categoryPerson, String categoryType) {
		this.name = name;
		this.thumb = thumb;
		this.description = description;
		this.price = price;
		this.totalReview = totalReview;
		this.averageReview = averageReview;
		this.stock = stock;
		this.categoryPerson = categoryPerson;
		this.categoryType = categoryType;
	}
	
	public Product(int id, String name, String thumb, String description, int price, int stock, String categoryPerson, String categoryType) {
		this.id = id;
		this.name = name;
		this.thumb = thumb;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryPerson = categoryPerson;
		this.categoryType = categoryType;
	}


	public String getName() {
		return name;
	}

	public String getThumb() {
		return thumb;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public int getTotalReview() {
		return totalReview;
	}

	public double getAverageReview() {
		return averageReview;
	}

	public int getStock() {
		return stock;
	}

	public String getCategoryPerson() {
		return categoryPerson;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public int getId() {
		return id;
	}
	
}