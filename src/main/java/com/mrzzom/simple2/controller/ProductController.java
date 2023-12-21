package com.mrzzom.simple2.controller;

import com.mrzzom.simple2.model.dto.v1.product.ProductRequestDTO;
import com.mrzzom.simple2.model.dto.v1.product.ProductResponseDTO;
import com.mrzzom.simple2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll(){
        List<ProductResponseDTO> product = service.findAll();
        return ResponseEntity.ok(product);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        ProductResponseDTO product = service.findById(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> save(@RequestBody ProductRequestDTO product) {
        ProductResponseDTO data = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponseDTO> update(@RequestBody ProductRequestDTO product, @PathVariable Long id) {
        ProductResponseDTO p = service.update(product, id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
}
