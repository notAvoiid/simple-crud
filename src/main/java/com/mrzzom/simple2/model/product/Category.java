package com.mrzzom.simple2.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Embeddable
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "product_category_name", length = 25)
    private String name;

}
