package controller.product;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ProductManager;

public class DeleteProductController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	{
		ProductManager manager = ProductManager.getInstance();        

        Map<String, String[]> paramMap = request.getParameterMap();
        List<String> selectedIds = new ArrayList<>();
        
        for (String paramName : paramMap.keySet()) {
            if (paramName.startsWith("checked_")) {
                selectedIds.add(paramName.replace("checked_", ""));
            }
        }
        if (selectedIds == null || selectedIds.size() < 1) {
            request.setAttribute("errorMsg", "삭제할 상품을 선택해주세요.");
            return "redirect:/admin";
        }
		
        int successCount = 0;
        for (String id : selectedIds) {
            successCount += manager.removeProduct(id);
        }
        
        if (successCount != selectedIds.size()) {
            request.setAttribute("errorMsg", "일부 상품 삭제에 실패했습니다.");
        }
        return "redirect:/admin";
    }
}
