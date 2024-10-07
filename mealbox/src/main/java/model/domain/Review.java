// Review.java (자바빈즈 클래스)
package com.example;

public class Review {
    private String productId;
    private String nickname;
    private String profile;
    private String date;
    private int rating;
    private String text;
    private String product;
    private String reviewImg;

    public Review() {} // 기본 생성자

    // 생성자
    public Review(String productId, String nickname, String profile, String date, int rating, String text, String product, String reviewImg) {
        this.productId = productId;
        this.nickname = nickname;
        this.profile = profile;
        this.date = date;
        this.rating = rating;
        this.text = text;
        this.product = product;
        this.reviewImg = reviewImg;
    }

    // Getter와 Setter
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public String getReviewImg() { return reviewImg; }
    public void setReviewImg(String reviewImg) { this.reviewImg = reviewImg; }
}