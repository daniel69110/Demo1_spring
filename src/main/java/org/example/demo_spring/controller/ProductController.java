package org.example.demo_spring.controller;

import org.example.demo_spring.model.Product;
import org.example.demo_spring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable UUID id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }


    @GetMapping("/filter")
    @ResponseBody
    public List<Product> filterProducts(
            @RequestParam String category,
            @RequestParam double maxPrice
    ) {
        return productService.filterProducts(category, maxPrice);
    }

}
