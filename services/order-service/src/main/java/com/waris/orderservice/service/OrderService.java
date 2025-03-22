package com.waris.orderservice.service;

import com.waris.orderservice.dto.OrderMapper;
import com.waris.orderservice.dto.OrderResponse;
import com.waris.orderservice.model.Order;
import com.waris.orderservice.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    public List<OrderResponse> getAllOrder(){
        List<Order> list = orderRepository.findAll();
        List<OrderResponse> response= new ArrayList<>();

        for (Order order: list){
            OrderResponse el = OrderMapper.fromOrder(order);
            response.add(el);
        }
        return response;
    }

    public OrderResponse getAllOrderById(Integer Id){
        return orderRepository.findById(Id)
                .map(orderMapper::fromModelToResponse)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Aucune commande trouvé avec ID: %d", Id)));
    }

}
