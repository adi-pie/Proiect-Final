package ro.sda.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Product;
import ro.sda.finalproject.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProducts(){return productRepository.findAll();}
    public List<Product> findProductsByAuthor(Author author){return productRepository.findByAuthor(author);}
    //public List<Product> getProductsbyBookType(String bookType){return productRepository.findByBookType(bookType);}

    public void saveProduct(Product product){productRepository.save(product);}
    public void updateProduct(Product product){productRepository.save(product);}

    public List<Product> findProduct(String title) {return productRepository.findByTitle(title);}

}
