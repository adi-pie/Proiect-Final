package ro.sda.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Product;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    public List<Product> findAll();
    public Optional<Product> findById(Integer id);
    public List<Product> findByBookType(String bookType);

    public List<Product> findByAuthor(Author author);
    public List<Product> findByTitle (String string);

}
