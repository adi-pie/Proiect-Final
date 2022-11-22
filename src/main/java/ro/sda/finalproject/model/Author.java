package ro.sda.finalproject.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "author")


public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String FirstName;
    private String LastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
