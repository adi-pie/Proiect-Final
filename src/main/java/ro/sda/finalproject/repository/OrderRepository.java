package ro.sda.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.finalproject.enums.BookType;
import ro.sda.finalproject.enums.OrderStatus;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Order;
import ro.sda.finalproject.model.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer>{

    public List<Order> findAll();

    Optional<Order> findOrderByOrderStatus(OrderStatus orderStatus);

    Optional<Order> findOrderByOrderId(Integer orderId);

}
