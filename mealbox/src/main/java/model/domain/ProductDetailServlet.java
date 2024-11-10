//package model.domain;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class ProductDetailServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 요청 파라미터에서 productId를 가져옴 (String을 int로 변환)
//        String productIdStr = request.getParameter("productId");
//        int productId = Integer.parseInt(productIdStr);  // productId를 int로 변환
//
//        // 상품 정보를 가져오는 로직 (예: 데이터베이스나 하드코딩된 상품 정보에서)
//        Product product = getProductDetails(productId);
//        
//        // 상품의 평균 평점을 계산 (예: 데이터베이스에서 리뷰 데이터를 가져오는 로직)
//        double averageScore = getAverageRating(productId);
//
//        // 'product' 객체를 request에 저장
//        request.setAttribute("product", product);
//        request.setAttribute("averageScore", averageScore);
//
//        // JSP로 포워딩
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/path/to/productDetailPage.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    // 상품 정보를 가져오는 메서드 (예시: 하드코딩된 데이터)
////    private Product getProductDetails(int productId) {
//        // Product 객체 생성 후 필드를 수동으로 세팅
////        Product product = new Product();
////        if (productId == 1) {
////            product.setName("곱도리탕");
////            product.setThumb("../img/gobdoritang.png");
////            product.setDescription("곱도리탕");
////            product.setPrice(13000);
////            product.setTotalReview(100);
////            product.setAverageReview(4.0);
////            product.setStock(50);
////            product.setCategoryPerson("대인");
////            product.setCategoryType("음식");
////        } else if (productId == 2) {
////            product.setName("딸기시루");
////            product.setThumb("../img/strawberrysiru.png");
////            product.setDescription("딸기시루");
////            product.setPrice(15000);
////            product.setTotalReview(80);
////            product.setAverageReview(5.0);
////            product.setStock(30);
////            product.setCategoryPerson("대인");
////            product.setCategoryType("음식");
////        }
////        return product;
////    }
//
//    // 평균 평점을 가져오는 메서드 (예시: 하드코딩된 값)
//    private double getAverageRating(int productId) {
//        if (productId == 1) {
//            return 4.0;
//        } else if (productId == 2) {
//            return 5.0;
//        }
//        return 0.0;
//    }
//}