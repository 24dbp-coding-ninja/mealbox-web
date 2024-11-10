package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import model.domain.Product;
import model.service.ProductManager;

import controller.Controller;

public class ListProductController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ProductManager manager = ProductManager.getInstance();
		// List<Product> productList = manager.findProductList();
		
		// mock data
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product("강아지 간식", "images/example.png", "니모에게서 인증을 받은 강아지용 간식!", 1300, 82, 3, 19, "1", "한식"));
		productList.add(new Product("옥수수 크림치즈 베이글", "images/example.png", "당도 300", 2500, 5, 1, 20, "4", "분식"));
		productList.add(new Product("청국장", "images/example.png", "청국장 청국장 청국장 청국장 청국장", 18000, 0, 5, 30, "2", "양식"));
		productList.add(new Product("뿌링클 치즈볼", "images/example.png", "뿌링클 치즈볼", 18000, 0, 5, 30, "2", "양식"));
		productList.add(new Product("음식명", "images/example.png", "음식", 18000, 0, 5, 30, "2", "한식"));
		productList.add(new Product("차돌떡볶이", "images/example.png", "청년다방 또보겠지떡볶이", 18000, 0, 5, 30, "2", "양식"));
		productList.add(new Product("초콜릿 파르페", "images/example.png", "초콜릿 파르페의 설명", 18000, 0, 5, 30, "2", "한식"));
		productList.add(new Product("말차라떼", "images/example.png", "말차라떼의 설명", 18000, 0, 5, 30, "2", "분식"));
		productList.add(new Product("바질 치즈 치아바타", "images/example.png", "바질 치즈 치아바타의 설명", 18000, 0, 5, 30, "2", "양식"));
		productList.add(new Product("음식2", "images/example.png", "음식의 기이이이이이이이이이이이이이이이이이이이이이이이이이이이인 설명", 18000, 0, 5, 30, "2", "양식"));
				
		request.setAttribute("productList", productList);
		
		return "/product/mainPage.jsp";
	}
}
