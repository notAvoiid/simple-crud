package com.mrzzom.simple2.model.product;


import com.mrzzom.simple2.model.client.Client;
import com.mrzzom.simple2.model.dto.v1.product.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity @Table(name = "product") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 25, nullable = false)
    private String name;

    @Column(name = "product_price", length = 10, nullable = false)
    private Double price;

    @Embedded
    private Category category;

    @Column(name = "product_quantity", length = 10)
    private Long quantityStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    public Product(ProductRequestDTO product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.quantityStock = product.getQuantityStock();

    }
}
