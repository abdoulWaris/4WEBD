package com.waris.eventservice.repository;

import com.waris.eventservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT P FROM Product P WHERE P.fl_Sup = 'N'")
    List<Product> FindByFlSup(String flag);

    List<Product> findAllByIdInOrderById(List<Integer> ids);
}
