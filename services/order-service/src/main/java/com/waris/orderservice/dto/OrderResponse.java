package com.waris.orderservice.dto;

import java.math.BigDecimal;

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal amount,
        String customerId
) {
}
