package org.example.product;

import java.util.List;
import java.util.UUID;

public class ProductService {
    ProductRepository productRepository = ProductRepository.getInstance();

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException
                ("Prooduct with id %s not found".formatted(id.toString())));


    }
}
