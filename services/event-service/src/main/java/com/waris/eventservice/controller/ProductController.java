package com.waris.eventservice.controller;

import com.waris.eventservice.Dto.ProductPurchaseRequest;
import com.waris.eventservice.Dto.ProductPurchaseResponse;
import com.waris.eventservice.Dto.ProductRequest;
import com.waris.eventservice.Dto.ProductResponse;
import com.waris.eventservice.model.Product;
import com.waris.eventservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(productService.createUser(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(productService.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Integer productId
    ) {
        return ResponseEntity.ok(productService.searchProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.getAllProduct());
    }
}
