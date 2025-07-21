package org.example.demo_spring.service;

import org.example.demo_spring.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(UUID.fromString("11111111-1111-1111-1111-111111111111"), "iPhone", "Electronique", 999.99));
        products.add(new Product(UUID.fromString("22222222-2222-2222-2222-222222222222"), "Samsung TV", "Electronique", 799.99));
        products.add(new Product(UUID.fromString("33333333-3333-3333-3333-333333333333"), "Chaise", "Fourniture", 49.99));
        products.add(new Product(UUID.fromString("44444444-4444-4444-4444-444444444444"), "Table", "Fourniture", 149.99));
    }


    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(UUID id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public List<Product> filterProducts(String category, double maxPrice) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getMaxPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}
