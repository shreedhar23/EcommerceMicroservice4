package com.learn.microservices.ecommerce.customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn.microservices.ecommerce.customer.model.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	public ResponseEntity<Object> createCustomer(Customer customer) 
	{
	    System.out.println("Inside say hi");
	    Customer customer2 = customerDAO.save(customer);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customer2.getCustomerId()).toUri();

		return ResponseEntity.created(location).build();
	    
	}
	public List<Customer> getAllCustomer() {
		return customerDAO.findAll();
	}
	public Optional<Customer>  getCustomer(long id) {
		return customerDAO.findById(id);

	}
	public void deleteCustomer(long id) {
		customerDAO.deleteById(id);
	}
	
	public ResponseEntity<Object> updateCustomer( Customer customer,  long id) {

		Optional<Customer> customerOptional = customerDAO.findById(id);

		if (!customerOptional.isPresent()){
			return ResponseEntity.notFound().build();
		}
		Customer customerFromDB = customerOptional.get();
		//if(customer.get)
		customer.setCustomerId(id);
		
		customerDAO.save(customer);

		return ResponseEntity.noContent().build();
	}
}
