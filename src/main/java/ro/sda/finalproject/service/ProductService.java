package ro.sda.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalproject.enums.BookType;
import ro.sda.finalproject.model.Product;
import ro.sda.finalproject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProducts(){return productRepository.findAll();}
    public void createProduct(Product product){productRepository.save(product);}
    public Product findProductById(int productId){return productRepository.findById(productId);}
    public List<Product> getProductByBookType(String bookType){return productRepository.findByBookType(BookType.valueOf(bookType));}

    public void saveProduct(Product product){productRepository.save(product);}
    public void updateProduct(Product product){productRepository.save(product);}

    public List<Product> findProduct(String title) {return productRepository.findByTitle(title);}
    public List<Product> findProductByTitleOrAuthor (String search){return productRepository.findByTitle(search);}
    public void deleteProduct(int product_id) {
        productRepository.findById(product_id);
        boolean exists = productRepository.existsById(product_id);
        if (!exists) {
            throw new IllegalStateException("Product with id " + product_id + " does not exists");
        }
        productRepository.deleteById(product_id);
    }

    public Product findProductInfo(String code) {
        Product product = (Product) this.findProduct(code);
        if (product == null) {
            return null;
        }
        return new Product(product.getProduct_id(), product.getTitle(), product.getPrice());
    }

}
