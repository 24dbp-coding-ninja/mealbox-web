package controller.product;
import controller.Controller;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.domain.Product;
import model.service.ProductManager;
public class ReadProductController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductManager manager = ProductManager.getInstance();
		List<Product> productList = manager.findProductList();

		request.setAttribute("productList", productList);
		return "/admin/adminPage.jsp";
	}
}