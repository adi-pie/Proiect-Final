package ro.sda.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.sda.finalproject.model.Product;
import ro.sda.finalproject.service.ProductService;

import java.util.List;

@Controller
public class ProductController{

    @Autowired
    ProductService productService;

    private List<Product> searchProductList;

    @GetMapping("/productlist")
    public String getAllProducts(ModelMap productMap) {
        productMap.addAttribute("products", productService.getAllProducts());
        productMap.addAttribute("productSearchForm", new Product());
        productMap.addAttribute("productsSearchResult", searchProductList);
        return "productlist";
    }

    @PostMapping("/productlist")
    public String searchProducts(@ModelAttribute("productsSearchResult") Product productForm) {
        searchProductList = productService.findProduct(productForm.getTitle());
        return "redirect:/productlist";
    }
    @GetMapping("/searchProductList")
    public ModelAndView searchProductsByTitle() {
        ModelAndView modelAndView = new ModelAndView("productlist");
        modelAndView.addObject("productsSearchResult", searchProductList);
        return modelAndView;
    }

    @GetMapping("/createProduct")
    public String createProduct(ModelMap modelmap) {
        modelmap.addAttribute("saveProductForm", new Product());
        return "createproduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("saveProduct") Product product) {
        productService.saveProduct(product);
        return "redirect:/productlist";
    }

    @GetMapping("/updateProduct")
    public String getUpdateProduct(ModelMap modelmap) {
        modelmap.addAttribute("updateProductForm", new Product());
        return "editproduct";
    }

    @PostMapping("/updateProduct")
    public String postUpdateProduct(@ModelAttribute("updateProductForm") Product product) {
        productService.updateProduct(product);
        return "redirect:/productlist";
    }
}


