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
		
		if(request.getMethod().equals("GET")) {
		    List<Product> productList = manager.findProductList();

		    request.setAttribute("productList", productList);
		    return "/product/productsPage.jsp";
		}

		// method가 POST인 경우 검색
		List<Product> productList = manager.searchProduct(request.getParameter("keyword"));
        request.setAttribute("productList", productList);
		return "/product/productsPage.jsp";
	}
}