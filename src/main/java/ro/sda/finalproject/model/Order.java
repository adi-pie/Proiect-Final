package ro.sda.finalproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private String username;
    private int totalCost;
}
