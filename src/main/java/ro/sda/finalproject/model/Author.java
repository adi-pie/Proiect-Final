package ro.sda.finalproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "author_id")
    private int author_id;
    private String firstname;
    private String lastname;


    @OneToMany (fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<Product> authorsProducts ;

     @Override
    public String toString() {
        return String.format("%s %s", firstname, lastname);
    }

    /*
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }*/


}

