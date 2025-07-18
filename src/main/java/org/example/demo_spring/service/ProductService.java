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

        products.add(new Product(UUID.randomUUID(), "iPhone", "Electronique", 999.99));
        products.add(new Product(UUID.randomUUID(), "Samsung TV", "Electronique", 799.99));
        products.add(new Product(UUID.randomUUID(), "Chaise", "Fourniture", 49.99));
        products.add(new Product(UUID.randomUUID(), "Table", "Fourniture", 149.99));
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
