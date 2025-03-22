package com.waris.orderservice.dto;

import com.waris.orderservice.model.Order;
import com.waris.orderservice.model.OrderLine;

public class OrderLineMapper {

    public static OrderLine toOrderLine(OrderLineRequest request){
        if (request == null){
            return null;
        }
        return OrderLine.builder()
                .id(request.id())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.id())
                                .build()
                )
                .quantity(request.orderId())
                .build();
    }

    public static OrderLineResponse fromOrder(OrderLine orderLine){
        if (orderLine == null){
            return null;
        }
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }

    public OrderLine fromRequestToModel(OrderLineRequest request){
        return toOrderLine(request);
    }

    public OrderLineResponse fromModelToResponse(OrderLine orderLine){
        return fromOrder(orderLine);
    }
}
