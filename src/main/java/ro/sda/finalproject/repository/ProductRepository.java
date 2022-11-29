package ro.sda.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.finalproject.enums.BookType;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAll();
    public Product findById(int product_id);

    public List<Product> findByBookType(BookType bookType);

     public List<Product> findByTitle (String string);


    //@Query(value = "select * from librarie.product p where p.title like '%:search%' or p.author like '%:search'", nativeQuery = true)
    //public List<Product> findByTitleOrAuthor (@Param("search") String search);

}
