package com.waris.orderservice.dto;

import com.waris.orderservice.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public static Order toOrder(OrderRequest request){
        if (request == null) {
            return null;
        }
        return Order.builder()
                .id(request.id())
                .reference(request.reference())
                .totalAmount(request.amount())
                .customerId(request.customerId())
                .build();
    }

    public static OrderResponse fromOrder(Order order){
        if (order == null) {
            return null;
        }
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getCustomerId()
        );
    }

    public Order fromRequestToModel(OrderRequest request){
        return toOrder(request);
    }

    public OrderResponse fromModelToResponse(Order order){
        return fromOrder(order);
    }

}
