package com.waris.eventservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private double availableQuantity;
    @Column(columnDefinition = "varchar(255) default 'N'")
    private String fl_Sup;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
