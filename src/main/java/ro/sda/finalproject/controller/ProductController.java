package ro.sda.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.sda.finalproject.model.Author;
import ro.sda.finalproject.model.Product;
import ro.sda.finalproject.repository.AuthorRepository;
import ro.sda.finalproject.repository.ProductRepository;
import ro.sda.finalproject.service.AuthorService;
import ro.sda.finalproject.service.ProductService;
import ro.sda.finalproject.utils.ImageUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller

public class ProductController{

    @Autowired
    ProductService productService;
    AuthorService authorService;
    ProductRepository productRepository;
    AuthorRepository authorRepository;
    ImageUtil imageUtil;

    private List<Product> productList;
    private Product product;


    @GetMapping("/productlist")
    public String productList(ModelMap productMap) {
        productList = productService.getAllProducts();
        productMap.addAttribute("products", productList);
       return "productlist";
    }

  /*  @PostMapping("/productlist")
    public String searchProducts(@ModelAttribute("productsSearchResult") Product productForm) {
        productList = productService.findProduct(productForm.getTitle());
        return "/productlist";

    }*/

/*    @GetMapping("/searchproductlist")
    public ModelAndView searchProductsByTitle() {
        ModelAndView modelAndView = new ModelAndView("productlist");
        modelAndView.addObject("productsSearchResult", searchProductList);
        return modelAndView;
    }*/


    @GetMapping("/createproduct")
    public String createProduct(ModelMap modelmap) {
        modelmap.addAttribute("newProduct", new Product());
        return "/createproduct";
    }

    @PostMapping(value = "/createproduct/new")
    public String createProduct(Product newProduct){
        productService.saveProduct(newProduct);
        return "redirect:/productlist";
    }

   @GetMapping(value="/product/{productId}", produces = MediaType.IMAGE_PNG_VALUE)
   public String getProductById(@PathVariable int productId, ModelMap productMap) {
       Product foundProduct = productService.findProductById(productId);
       productMap.addAttribute("products", foundProduct);
       productMap.addAttribute("imgUtil", new ImageUtil());
       return "product";
    }
    @PostMapping(value = "/product/edit/{productId}/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                    produces ={MediaType.APPLICATION_ATOM_XML_VALUE,
                                MediaType.APPLICATION_JSON_VALUE} )
    public String editProduct(@PathVariable int productId, Product product, MultipartFile imgData) throws IOException {
        product.setProduct_id(productId);
        product.setThumbnail(imgData.getBytes());
        productService.saveProduct(product);
        return "redirect:/product/" + productId;
    }


    @GetMapping(path = "/product/delete/{product_id}")
    public String deleteProduct(@PathVariable("product_id") int product_id){

        productService.deleteProduct(product_id);
        return "redirect:/productlist";
    }
    }



