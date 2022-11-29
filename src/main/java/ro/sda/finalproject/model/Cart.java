package ro.sda.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable{

    @Id
    @Column(name = "cart_id")
    private String cartId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product")
    private Product product;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "order")
    private Order order;

    private int quantity;

    private int price;

    private int amount;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
