package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.domain.Product;
import model.service.ProductManager;

public class UpdateProductController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductManager manager = ProductManager.getInstance();
		
		// 혹은 request.getParameterValues()를 사용
		// for문으로 length 맞춰서 product를 일일히 생성해 전송
		
		Product product = new Product(
					Integer.parseInt(request.getParameter("id")),	
					request.getParameter("name"),
					request.getParameter("thumb"),
					request.getParameter("desc"),
					Integer.parseInt(request.getParameter("price")),
					Integer.parseInt(request.getParameter("stock")),
					Integer.parseInt(request.getParameter("peopleCategory")),
					Integer.parseInt(request.getParameter("foodTypeCategory"))
		);
		
//		try {
			manager.updateProduct(product);
			return "redirect:/admin.jsp";
//		} catch (ExistingProductException e) {
//			request.setAttribute("createFailed", true);
//			request.setAttribute("exception", e);
//			request.setAttribute("product", product);
//			return "/admin.jsp";
//		}
	}
	
}