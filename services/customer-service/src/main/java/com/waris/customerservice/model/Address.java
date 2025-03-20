package com.waris.customerservice.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;

}
