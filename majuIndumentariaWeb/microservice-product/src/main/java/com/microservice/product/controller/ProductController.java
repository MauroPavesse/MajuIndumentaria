package com.microservice.product.controller;

import com.microservice.product.entities.Product;
import com.microservice.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody Product product){
        productService.save(product);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllProduct(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("/search-by-category/{categoryId}")
    public ResponseEntity<?> findByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(productService.findByCategoryId(categoryId));
    }
}
