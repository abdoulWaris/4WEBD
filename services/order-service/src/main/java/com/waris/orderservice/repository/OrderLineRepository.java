package com.waris.orderservice.repository;

import com.waris.orderservice.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
}
