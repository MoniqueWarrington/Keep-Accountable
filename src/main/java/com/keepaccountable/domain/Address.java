package com.keepaccountable.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Address {

    private String address;
    private String city;
    private String country;
    private String postCode;
}
