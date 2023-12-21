package com.mrzzom.simple2.model.dto.v1.client;

import com.mrzzom.simple2.model.product.Product;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class ClientRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String email;
    private String phoneNumber;
    private List<Product> products;

}
