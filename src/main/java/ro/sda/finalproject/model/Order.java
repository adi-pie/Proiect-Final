package ro.sda.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.sda.finalproject.enums.OrderStatus;
import ro.sda.finalproject.enums.PaymentMethod;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private OrderStatus orderStatus;
    private double quantity;
    private Date orderDate;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private final Set<Product> products = new HashSet<>();

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "client")
    private User user;

    @OneToMany (fetch = FetchType.LAZY)
    private List<Product> productList;

}
