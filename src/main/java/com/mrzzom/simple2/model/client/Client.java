package com.mrzzom.simple2.model.client;

import com.mrzzom.simple2.model.dto.v1.client.ClientRequestDTO;
import com.mrzzom.simple2.model.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity @Table(name = "client") @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String email;

    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Product> products;

    public Client(ClientRequestDTO request) {
        this.firstName = request.getFirstName();
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
        this.products = request.getProducts();
    }
}
