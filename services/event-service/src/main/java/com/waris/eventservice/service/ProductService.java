package com.waris.eventservice.service;

import com.waris.eventservice.Dto.*;
import com.waris.eventservice.exception.ProductPurchaseException;
import com.waris.eventservice.model.Product;
import com.waris.eventservice.repository.CategoryRepository;
import com.waris.eventservice.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CategoryRepository categoryRepository;
     private final ProductMapper productMapper;
     private final ProductRepository productRepository;

     public Product createUser(ProductRequest request){
         var newProduct = productMapper.fromDtoToModel(request);
         return productRepository.save(newProduct);
     }

     public void updateProduct(ProductRequest request,Integer productId){
         var foundProduct = productRepository.findById(productId).orElseThrow();
         var foundCategory = categoryRepository.findById(request.categoryId());
          mergedProduct(foundProduct, request);
          productRepository.save(foundProduct);
     }

    private void mergedProduct(Product foundProduct, ProductRequest request) {
         foundProduct.setDescription(request.description());
         foundProduct.setName(request.name());
         foundProduct.setPrice(request.price());
         foundProduct.setAvailableQuantity(request.availableQuantity());
        var foundCategory = categoryRepository.findById(request.categoryId());

        if(foundCategory.isPresent()){
            foundProduct.setCategory(foundCategory.get()); ;
         }

    }

    public boolean softDelete(Integer Id){
         var oldProduct = productRepository.findById(Id).orElseThrow();
        oldProduct.setFl_Sup("O");
        productRepository.save(oldProduct);
        return true;
    }

    public List<ProductResponse> getAllProduct(){
         List<Product> list = productRepository.FindByFlSup("N");
         List<ProductResponse> finalList = new ArrayList<>();

         for (Product response: list){
             ProductResponse add = ProductMapper.toProductResponse(response);
             finalList.add(add);
         }
         return finalList;
     }

     public boolean existsProduct(Integer productId){
         return productRepository.findById(productId).isPresent();
     }

     public ProductResponse searchProductById(Integer productId) {
         return productRepository.findById(productId)
                 .map(ProductMapper::toProductResponse)
                 .orElseThrow(() -> new EntityNotFoundException("le produit avec l'Id %s est introuvable:: " + productId));
     }

    @Transactional(rollbackOn = ProductPurchaseException.class)
    public List<ProductPurchaseResponse> purchaseProducts(
            List<ProductPurchaseRequest> request
    ) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }
        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.fromModelToPurchaseDto(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }
}
