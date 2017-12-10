package com.fuse.customer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Login, String> {

	public Login findByFirstName(String firstName);

	public List<Login> findByLastName(String lastName);

}