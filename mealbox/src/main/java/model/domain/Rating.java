// Rating.java (상품 평점 정보를 담는 자바빈즈)
public class Rating implements java.io.Serializable {
    private String stars;
    private double score;

    public Rating() {} // 기본 생성자

    public Rating(String stars, double score) {
        this.stars = stars;
        this.score = score;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public String getStars() {
        return stars;
    }
    public double getScore() {
        return score;
    }
}