package controller.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProductManager;

public class DeleteProductController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	{
		String[] productId = request.getParameterValues("id");
	
		ProductManager manager = ProductManager.getInstance();
		int res = 0;
		
		for(int i=0; i<productId.length; i++) {
			res = res + manager.removeProduct(productId[i]);
		}
		
		if(res!=productId.length) {
			// 뭔가 한 두 개 덜 혹은 안 삭제되었음
			// return ... 
		}
		
		// 전부 제대로 삭제된 경우
		return "redirect:/admin/products";
    }
}
