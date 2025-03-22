package com.waris.orderservice.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "le montant de la commande doit être positif")
        BigDecimal amount,
        @NotNull(message = "le client est obligatoire")
        @NotEmpty(message = "le client est obligatoire")
        @NotBlank(message = "le client est obligatoire")
        String customerId,
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
) {
}
