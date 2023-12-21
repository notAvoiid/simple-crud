package com.mrzzom.simple2.model.dto.v1.client;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mrzzom.simple2.model.client.Address;
import com.mrzzom.simple2.model.product.Product;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonPropertyOrder({"id", "firstName", "email", "address", "products"})
public class ClientResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String email;
    private Address address;
    private List<Product> products;


}
