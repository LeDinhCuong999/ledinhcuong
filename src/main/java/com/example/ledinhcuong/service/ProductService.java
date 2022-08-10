package com.example.ledinhcuong.service;

import com.example.ledinhcuong.entity.Product;
import com.example.ledinhcuong.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> findById(String id){
        return productRepository.findById(id);
    }

    public Optional<Product> updateById(String id) {
        return productRepository.updateById(id);
    }
}
