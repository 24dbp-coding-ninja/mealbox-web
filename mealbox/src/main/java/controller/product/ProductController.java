package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Product;
import model.service.ProductManager;

public class ProductController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductManager manager = ProductManager.getInstance();
		Product product = manager.getDetail(Integer.parseInt(request.getParameter("id")));

	    request.setAttribute("product", product);
		return "/product/detailPage.jsp";
	}
}