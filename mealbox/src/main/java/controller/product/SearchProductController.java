package controller.product;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.domain.Product;
import model.service.ProductManager;

class SearchProductController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String keyword = request.getParameter("orderBy");
		ProductManager manager = ProductManager.getInstance();
		
		List<Product> searchResult = manager.orderBy(keyword);
		request.setAttribute("productList", searchResult);
		
		return "/products/main.jsp";
	}
	
}