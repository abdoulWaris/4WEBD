package com.waris.customerservice.service;

import com.waris.customerservice.dto.CustomerMapper;
import com.waris.customerservice.dto.CustomerRequest;
import com.waris.customerservice.dto.CustomerResponse;
import com.waris.customerservice.exception.CustomerNotFoundException;
import com.waris.customerservice.model.Customer;
import com.waris.customerservice.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var findedCustomer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Impossible de trouver l'utilisateur avec l'ID: %s", request.id())
                ));
        mergerCustomer(findedCustomer, request);
        customerRepository.save(findedCustomer);
    }

    private void mergerCustomer(Customer findedCustomer, @Valid CustomerRequest request) {

        if (StringUtils.isNotBlank(request.firstName())){
            findedCustomer.setFirstName(request.firstName());
        }
        if (StringUtils.isNotBlank(request.lastName())){
            findedCustomer.setLastName(request.lastName());
        }
        if (StringUtils.isNotBlank(request.email())){
            findedCustomer.setEmail(request.email());
        }
        if (request.firstName() != null){
            findedCustomer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomer() {
        List<Customer> fetchList = customerRepository.findAll();
        List<CustomerResponse>listOfCustomer = new ArrayList<>();
        for (Customer customer: fetchList){
            CustomerResponse response = CustomerMapper.fromCustomer(customer);
            listOfCustomer.add(response);
        }
        return listOfCustomer;
    }

    public Boolean existsById(String customerId) {
        return customerRepository.findById(customerId)
        .isPresent();
    }

    public CustomerResponse findAllCustomerById(String customerId) {

        return customerRepository.findById(customerId)
                .map(customerMapper::fromCustomerToDto)
                .orElseThrow(() ->new CustomerNotFoundException(format("Il n'y a pas de clients pour l'ID: %s", customerId)));
    }

    public void softDeleteCustomer(String customerId) {
         customerRepository.deleteById(customerId);
    }
}
