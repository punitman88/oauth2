package com.fuse.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Collection<Login> findAll() {
		return this.customerRepository.findAll();
	}

	public Login findOne(String id) {
		return customerRepository.findOne(id);
	}

	public Login save(Login customer) {
		return customerRepository.save(customer);
	}

	/*
	 * WARNING!! If all the values are not provided during update, this might result
	 * in inconsistent data
	 */
	public Login updateAllFields(String id, Login customer) {
		Login customerToUpdate = customerRepository.findOne(id);
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		return customerRepository.save(customerToUpdate);
	}

	public void delete(String id) {
		customerRepository.delete(id);
	}

}
