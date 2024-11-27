package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.domain.Product;
import model.service.ProductManager;
import java.util.*;

public class UpdateProductController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductManager manager = ProductManager.getInstance();

        Map<String, String[]> paramMap = request.getParameterMap();
        List<String> selectedIds = new ArrayList<>();
        
        for (String paramName : paramMap.keySet()) {
            if (paramName.startsWith("checked_")) {
                selectedIds.add(paramName.replace("checked_", ""));
            }
        }

        for (String selectedId : selectedIds) {
            Product product = new Product(
                    Integer.parseInt(request.getParameter("id_" + selectedId)),
                    request.getParameter("name_" + selectedId),
//					request.getParameter("thumb" + selectedId),
                    "img",
					request.getParameter("description_" + selectedId),
                    Integer.parseInt(request.getParameter("price_" + selectedId).replace("원", "")),
                    Integer.parseInt(request.getParameter("stock_" + selectedId)),
                    Integer.parseInt(request.getParameter("peopleCategory_" + selectedId)),
                    Integer.parseInt(request.getParameter("foodTypeCategory_" + selectedId))
		        );
        
            manager.updateProduct(product);
        }

			return "redirect:/admin";
	}
	
}