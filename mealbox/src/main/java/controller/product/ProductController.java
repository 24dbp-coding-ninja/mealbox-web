package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Product;
import model.service.ProductManager;

public class ProductController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ProductManager manager = ProductManager.getInstance();
//		Product product = manager.getDetail(Integer.parseInt(request.getAttribute("id").toString()));

		Product product = new Product("강아지 간식", "../images/example.png", "니모에게서 인증을 받은 강아지용 간식!", 1300, 82, 19, 3, 1, 1);
		request.setAttribute("product", product);
		
		
		return "/product/detailPage.jsp";
	}
}