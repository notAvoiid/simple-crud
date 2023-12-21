package com.mrzzom.simple2.model.dto.v1.product;

import com.mrzzom.simple2.model.product.Category;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ProductRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private Double price;
    private Category category;
    private Long quantityStock;

}
