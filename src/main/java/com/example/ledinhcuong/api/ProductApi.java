package com.example.ledinhcuong.api;

import com.example.ledinhcuong.entity.Product;
import com.example.ledinhcuong.repository.ProductRepository;
import com.example.ledinhcuong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductApi {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Optional<Product> optionalProduct = productService.findById(String.valueOf(Integer.parseInt(id)));
        if(!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody Product Product){
        return ResponseEntity.ok(productService.save(Product));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> updateById(@PathVariable String id, @RequestBody Product updateProduct){
        Optional<Product> optionalProduct = productService.findById(id);
        if(!optionalProduct.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Product existingProduct = optionalProduct.get();
        existingProduct.setQuantity(updateProduct.getQuantity());
        return ResponseEntity.ok(productService.save(existingProduct));
    }
}
