package com.waris.eventservice.Dto;

import com.waris.eventservice.model.Category;
import com.waris.eventservice.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public static Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(
                        Category.builder()
                                .id(request.categoryId())
                                .build()
                )
                .build();
    }

    public static ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public static ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }

    public Product fromDtoToModel(ProductRequest product){
       return toProduct(product);
    }

    public ProductResponse fromModelToDto(Product product){
        return toProductResponse(product);
    }

    public ProductPurchaseResponse fromModelToPurchaseDto(Product product,double quantity){
        return toproductPurchaseResponse(product, quantity);
    }
}
