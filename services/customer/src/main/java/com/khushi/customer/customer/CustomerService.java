package com.khushi.customer.customer;

import com.khushi.customer.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private   final CustomerRepository repository;
    private  final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        var customer = mapper.toCustomer(request);
    return null;
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Customer with id %s not found", request.id()
                )));

        mergeCustomer(customer, request);
        repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            customer.setFirstname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setFirstname(request.email());
        }
        if(request.address() != null){
            customer.setAddress(request.address());
        }

    }

    public List<CustomerResponse> findAllCustmors() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId){
        return repository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(String customerId){
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No Customer found with the provided ID ::%s", customerId)
                ));
    }


    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
