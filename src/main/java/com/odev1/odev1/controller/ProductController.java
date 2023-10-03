package com.odev1.odev1.controller;

import com.odev1.odev1.entity.Product;
import com.odev1.odev1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @PostMapping
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id) {
        Product product=productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
        productRepository.deleteById(id);
        return product.getName();
    }
    @GetMapping("/expired-date/{date}")
    public List<Product> expiredDate(@PathVariable LocalDate date){
        return productRepository.findAllByExpiredDate(date);
    }
}
