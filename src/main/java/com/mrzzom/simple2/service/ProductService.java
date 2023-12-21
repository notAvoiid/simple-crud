package com.mrzzom.simple2.service;

import com.mrzzom.simple2.exceptions.EntityNotFoundException;
import com.mrzzom.simple2.model.dto.v1.client.ClientResponseDTO;
import com.mrzzom.simple2.model.product.Product;
import com.mrzzom.simple2.model.dto.v1.product.ProductRequestDTO;
import com.mrzzom.simple2.model.dto.v1.product.ProductResponseDTO;
import com.mrzzom.simple2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductResponseDTO findById(Long id){
    return repository.findById(id)
            .map(this::entityToDto)
            .orElseThrow(
                () -> new EntityNotFoundException(String.format("ID=%s not found", id))
        );
    }

    @Transactional
    public ProductResponseDTO update(ProductRequestDTO dto, Long id){
        Product product = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID=%s not found", id))
        );

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());


        ProductResponseDTO data = mapper.map(repository.save(product), ProductResponseDTO.class);
        return data;
    }


    @Transactional
    public ProductResponseDTO save(ProductRequestDTO product) {
        Product data = new Product(product);
        ProductResponseDTO dto = mapper.map(repository.save(data), ProductResponseDTO.class);
        return dto;
    }

    private ProductResponseDTO entityToDto(Product product) {
        return mapper.map(product, ProductResponseDTO.class);
    }
}
