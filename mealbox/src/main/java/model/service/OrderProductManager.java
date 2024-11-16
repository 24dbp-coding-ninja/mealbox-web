package model.service;

import java.sql.SQLException;
import java.util.List;
import model.dao.OrderProductDAO;
import model.domain.OrderProduct;

/**
 * 주문 상품 관리 클래스 (비즈니스 로직 처리 및 DAO 호출)
 */
public class OrderProductManager {
    private static OrderProductManager orderProductMan = new OrderProductManager();
    private OrderProductDAO orderProductDAO;

    // Private 생성자로 싱글톤 패턴 구현
    private OrderProductManager() {
        try {
            orderProductDAO = new OrderProductDAO(); // DAO 객체 생성
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Singleton 인스턴스 반환
    public static OrderProductManager getInstance() {
        return orderProductMan;
    }

    /**
     * 새로운 주문 상품 생성
     */
    public int createOrderProduct(OrderProduct orderProduct) throws SQLException {
        return orderProductDAO.create(orderProduct);
    }

    /**
     * 기존 주문 상품 업데이트
     */
    public int updateOrderProduct(OrderProduct orderProduct) throws SQLException {
        return orderProductDAO.update(orderProduct);
    }

    /**
     * 특정 주문 상품 삭제
     */
    public int removeOrderProduct(int orderId, int lineNo) throws SQLException {
        return orderProductDAO.remove(orderId, lineNo);
    }

    /**
     * 특정 주문의 모든 상품 삭제
     */
    public int removeAllOrderProducts(int orderId) throws SQLException {
        return orderProductDAO.removeAll(orderId);
    }

    /**
     * 특정 주문 상품 조회
     */
    public OrderProduct findOrderProduct(int orderId, int lineNo) throws SQLException {
        return orderProductDAO.findOrderProduct(orderId, lineNo);
    }

    /**
     * 특정 주문 ID의 모든 상품 조회
     */
    public List<OrderProduct> findOrderProductsInOrder(int orderId) throws SQLException {
        return orderProductDAO.findOrderProductInOrder(orderId);
    }
    
    /**
     * 주문에 포함된 상품들의 총 금액 계산
     */
    public int calculateTotalPrice(int orderId) throws Exception {
        return orderProductDAO.calculateTotalPrice(orderId);
    }
}
