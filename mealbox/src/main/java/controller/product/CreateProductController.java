package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.service.ProductManager;
import model.domain.Product;
//import model.service.ExistingProductException;

public class CreateProductController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductManager manager = ProductManager.getInstance();
		
		Product product = new Product(
					request.getParameter("newName"),
					request.getParameter("newThumb"),
					request.getParameter("newDesc"),
					Integer.parseInt(request.getParameter("newPrice")),
					Integer.parseInt(request.getParameter("newStock")),
					0,
					0.0,
					Integer.parseInt(request.getParameter("newPeopleCategory")),
					Integer.parseInt(request.getParameter("newFoodTypeCategory"))
		);

//		try {
			manager.createProduct(product);
			return "redirect:/admin.jsp";
//		} catch (ExistingProductException e) {
//			request.setAttribute("createFailed", true);
//			request.setAttribute("exception", e);
//			request.setAttribute("product", product);
//			return "/admin.jsp";
//		}
	}
	
}