package com.waris.eventservice.repository;

import com.waris.eventservice.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
