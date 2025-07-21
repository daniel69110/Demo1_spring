package org.example.demo_spring.controller;

import org.example.demo_spring.model.Product;
import org.example.demo_spring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


//    @GetMapping("/all")
//    @ResponseBody
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }
@GetMapping("/all")
public String showAllProducts(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    model.addAttribute("isFilter", false);
    return "products";
}

    @GetMapping("/product")
    public String showProductDetails(@RequestParam UUID id, Model model) {
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "productDetail";
        } else {
            return "product-not-found";
        }
    }





    @GetMapping("/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable UUID id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }


//    @GetMapping("/filter")
//    @ResponseBody
//    public List<Product> filterProducts(
//            @RequestParam String category,
//            @RequestParam double maxPrice
//    ) {
//        return productService.filterProducts(category, maxPrice);
//    }

    @GetMapping("/filter")
    public String showFilteredProducts(@RequestParam String category, @RequestParam double maxPrice, Model model) {
        model.addAttribute("products", productService.filterProducts(category, maxPrice));
        model.addAttribute("isFilter", true);
        return "products";
    }
}
