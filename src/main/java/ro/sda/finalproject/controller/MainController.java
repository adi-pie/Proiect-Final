package ro.sda.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.finalproject.model.Product;
import ro.sda.finalproject.service.ProductService;
import ro.sda.finalproject.utils.ImageUtil;

import java.util.List;

@Controller
public class MainController{
    @Autowired
    private ProductService productService;
    private Product product;

      @GetMapping(value = {"/", "/home","/index"})
    public String productList(ModelMap productMap) {
        List<Product> productList = productService.getAllProducts();
        productMap.addAttribute("imgUtil", new ImageUtil());
        productMap.addAttribute("products", productList);
        return "index";
    }


}