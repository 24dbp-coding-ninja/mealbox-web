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

		// method가 POST인 경우 검색 및 카테고리 선택
		List<Product> productList;
		String categoryType = request.getParameter("categoryType");
		String categoryValue = request.getParameter("categoryValue");
		String orderBy = request.getParameter("orderBy");
		
		if (orderBy == null) {
			orderBy = "";
		}
		
		if(categoryType != null && categoryValue != null) {
			productList = manager.searchProduct(categoryType, categoryValue, orderBy);
		} else {
			productList = manager.searchProduct(null, null, orderBy);
		}
		
		request.setAttribute("productList", productList);
		return "/product/productsPage.jsp";
	}
}