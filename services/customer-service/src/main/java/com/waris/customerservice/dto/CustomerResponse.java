package com.waris.customerservice.dto;

import com.waris.customerservice.model.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}