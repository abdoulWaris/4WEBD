package com.waris.customerservice.dto;

import com.waris.customerservice.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static Customer toCustomer(CustomerRequest request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public static CustomerResponse fromCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }

    public  CustomerResponse fromCustomerToDto(Customer customer) {
        return fromCustomer(customer);
    }
    public  Customer fromDtoToCustomer(CustomerRequest request) {
        return toCustomer(request);
    }

}