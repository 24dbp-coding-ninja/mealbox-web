// Review.java (자바빈즈 클래스)
package model.domain;

public class Review {
    private static int reviewCounter = 0; // 자동 증가할 reviewId 카운터
    private int reviewId;
    private String productId;
    private String nickname;
    private String profile;
    private String date;
    private Rating rating;
    private String text;
    private String product;
    private String reviewImg;

    public Review() { // 기본 생성자
        this.reviewId = reviewCounter++; // 리뷰 생성 시 자동으로 reviewId 할당
    }

    // 생성자
    public Review(String productId, String nickname, String profile, String date, String stars, double score, String text, String product, String reviewImg) {
        this.reviewId = reviewCounter++; // 리뷰 생성 시 자동으로 reviewId 할당
        this.productId = productId;
        this.nickname = nickname;
        this.profile = profile;
        this.date = date;
        this.rating = new Rating(stars, score); // Rating 객체 생성
        this.text = text;
        this.product = product;
        this.reviewImg = reviewImg;
    }

    // Getter와 Setter
    public int getReviewId() { return reviewId; }  // 리뷰 ID Getter

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getProfile() { return profile; }
    public void setProfile(String profile) { this.profile = profile; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Rating getRating() { return rating; }
    public void setRating(Rating rating) { this.rating = rating; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public String getReviewImg() { return reviewImg; }
    public void setReviewImg(String reviewImg) { this.reviewImg = reviewImg; }
}