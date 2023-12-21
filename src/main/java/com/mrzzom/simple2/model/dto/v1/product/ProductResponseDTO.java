package com.mrzzom.simple2.model.dto.v1.product;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mrzzom.simple2.model.product.Category;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonPropertyOrder({"id", "name", "price", "category"})
public class ProductResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double price;
    private Category category;

}
