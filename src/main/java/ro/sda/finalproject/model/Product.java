package ro.sda.finalproject.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String title;
    private String Description;
    private String Thumbnail;
    private int Price;

    @Column(name = "Book Type")
    private String bookType;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
