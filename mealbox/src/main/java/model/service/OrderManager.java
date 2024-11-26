package model.service;

import java.sql.SQLException;
import java.util.List;
import model.dao.OrderDAO;
import model.domain.Order;

/**
 * 주문 관리 클래스 (비즈니스 로직 처리 및 DAO 호출)
 */
public class OrderManager {
    private static OrderManager orderMan = new OrderManager();
    private OrderDAO orderDAO;

    private OrderManager() {
        try {
            orderDAO = new OrderDAO(); // DAO 객체 생성
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static OrderManager getInstance() {
        return orderMan;
    }

    /**
     * 특정 사용자의 주문 목록 조회
     */
    public List<Order> findOrdersInUser(String userId) throws SQLException {
        return orderDAO.findOrdersInUser(userId);
    }

    /**
     * 새로운 주문 생성
     */
    public int create(Order order) throws SQLException, ExistingOrderException {
        if (orderDAO.existingOrder(order.getOrderId())) {
            throw new ExistingOrderException(order.getOrderId() + "는 존재하는 주문아이디입니다.");
        }
        int orderId = orderDAO.create(order); // 생성된 orderId 반환
        order.setOrderId(orderId); // Order 객체에 orderId 설정
        return orderId;
    }

    /**
     * 기존 주문 업데이트 
     */
    public int update(Order order) throws SQLException, OrderNotFoundException {
        if (!orderDAO.existingOrder(order.getOrderId())) {
            throw new OrderNotFoundException(order.getOrderId() + "는 존재하지 않는 아이디입니다.");
        }
        return orderDAO.update(order);
    }

    /**
     * 주문 삭제
     */
    public int remove(int orderId) throws SQLException, OrderNotFoundException {
        if (!orderDAO.existingOrder(orderId)) {
            throw new OrderNotFoundException(orderId + "는 존재하지 않는 아이디입니다.");
        }
        return orderDAO.remove(orderId);
    }

    /**
     * 특정 주문 조회
     */
    public Order findOrder(int orderId) throws SQLException, OrderNotFoundException {
        Order order = orderDAO.findOrder(orderId);

        if (order == null) {
            throw new OrderNotFoundException(orderId + "는 존재하지 않는 아이디입니다.");
        }
        return order;
    }

    /**
     * 모든 주문 목록 조회 -> 본 프로젝트에서는 기능 구현 x
     */
    public List<Order> findOrderList() throws SQLException {
        return orderDAO.findOrderList();
    }
}
