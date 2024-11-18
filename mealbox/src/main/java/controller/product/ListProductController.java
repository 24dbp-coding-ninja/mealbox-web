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
		 List<Product> productList = manager.findProductList();

		request.setAttribute("productList", productList);
		System.out.println(productList);

		return "/product/mainPage.jsp";
	}
}