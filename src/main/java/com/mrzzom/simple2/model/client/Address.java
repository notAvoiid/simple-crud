package com.mrzzom.simple2.model.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Embeddable
public class Address {

    private String street;

    private String neighborhood;

    private String city;

    private String country;

}
