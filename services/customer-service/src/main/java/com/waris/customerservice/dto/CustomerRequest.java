package com.waris.customerservice.dto;

import com.waris.customerservice.model.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "le nom est obligatoire")
        String firstName,
        @NotNull(message = "le prenom est obligatoire")
        String lastName,
        @NotNull(message = "Customer Email is required")
        @Email(message = "Customer Email is not a valid email address")
        String email,
        Address address
) {


}
