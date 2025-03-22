package com.waris.orderservice.dto;

public record PurchaseResponse(
        Integer productId,
        double quantity
) {
}
