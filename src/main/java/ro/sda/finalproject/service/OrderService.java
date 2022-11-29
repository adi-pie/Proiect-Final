package ro.sda.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Order;
import ro.sda.finalproject.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service

public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void createOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.findOrderByOrderStatus(order.getOrderStatus());
        if (orderOptional.isPresent()) {
            throw new IllegalStateException("Order is present");
        }
        orderRepository.save(order);
        // System.out.println(author);
    }

    public Order saveOrder(Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(order.getOrderId());
        if (optionalOrder.isEmpty()) {
            return orderRepository.save(order);
        }
        throw new IllegalArgumentException("Author with id: " + order.getOrderId() + " already exists");
    }

    public Order updateOrder(Order order) {
        Optional<Order> optionalOrder = orderRepository.findOrderByOrderId(order.getOrderId());
        if (optionalOrder.isPresent()) {
            return orderRepository.save(order);
        }
        throw new IllegalArgumentException("There is no order with id: " + order.getOrderId());
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.findById(orderId);
        boolean exists = orderRepository.existsById(orderId);
        if (!exists) {
            throw new IllegalStateException("Order with id " + orderId + " does not exists");
        }
        orderRepository.deleteById(orderId);
    }

}
