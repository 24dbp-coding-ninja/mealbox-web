// Product.java (상품 정보를 담는 자바빈즈)
public class Product implements java.io.Serializable {
    private String id;
    private String name;
    private String image;
    private int price;
    private String description;
    private Rating rating;

    public Product() {} // 기본 생성자

    public Product(String id, String name, String image, int price, String description, Rating rating) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.rating = rating;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getImage() {
        return image;
    }
    public int getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public Rating getRating() {
        return rating;
    }
}