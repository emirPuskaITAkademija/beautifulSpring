package com.akademija.beautiful.controller.mvc.product;

import com.akademija.beautiful.bean.HelloWorldBean;
import com.akademija.beautiful.entity.product.Product;
import com.akademija.beautiful.entity.user.User;
import com.akademija.beautiful.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HelloWorldBean helloWorldBean;


    @GetMapping("/products")
    public String getAllProducts(Model model){
        System.out.println("HelloWorldBean-ProductController: " + helloWorldBean.hashCode());
        List<Product> products = productService.getAllProducts();
        model.addAttribute("proizvodi", products);
        return "product";
    }

    //http://localhost:8080/addProduct GET
    @GetMapping("/addProduct")
    public String showAddProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        try {
            productService.saveProduct(product);
            return "redirect:/products";
        }catch (Exception e){
            return "redirect:/addProduct?error";
        }
    }
}
