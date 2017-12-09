package com.fuse.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Collection<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	public Customer findOne(String id) {
		return customerRepository.findOne(id);
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer updateAllFields(String id, Customer customer) {
		Customer customerToUpdate = customerRepository.findOne(id);
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		return customerRepository.save(customerToUpdate);
	}

	public void delete(String id) {
		customerRepository.delete(id);
	}

}
