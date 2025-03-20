package com.waris.customerservice.web;

import com.waris.customerservice.dto.CustomerRequest;
import com.waris.customerservice.dto.CustomerResponse;
import com.waris.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class customerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String>createCustomer(
            @RequestBody CustomerRequest request
            ){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void>updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomer(){
        return ResponseEntity.ok(customerService.findAllCustomer());
    }

    @GetMapping("exists/{customer-id}")
    public ResponseEntity<Boolean> getExistingCustomer(
            @PathVariable("customer-id") String customerId){
        return ResponseEntity.ok(customerService.existsById(customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable("customerId") String customerId ){
         customerService.softDeleteCustomer(customerId);

            return ResponseEntity.accepted().build();
        }

}
