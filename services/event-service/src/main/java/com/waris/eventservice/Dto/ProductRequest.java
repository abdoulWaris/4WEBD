package com.waris.eventservice.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "le nom de l'évènement est obligatoire")
        String name,
        @NotNull(message = "la description de l'évènement est obligatoire")
        String description,
        @Positive(message = "La quantité doit être positive")
        double availableQuantity,
        @Positive(message = "La prix du billet doit être positive")
        BigDecimal price,
        @NotNull(message = "Un évènement a obligatoirement une categorie")
        Integer categoryId
) {
}
