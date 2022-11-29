package ro.sda.finalproject.model;

import lombok.*;
import ro.sda.finalproject.enums.BookType;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String title;
    private String description;
    @Lob
    @Column(name = "thumbnail", length = Integer.MAX_VALUE, nullable = true)
    private byte[] thumbnail;

    private double price;

    @Column (name = "book_type")
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "author_Id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_Id")
    private Order order;

    public Product(int product_id, String title, double price) {
    }

    public Product(List<Product> product) {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}