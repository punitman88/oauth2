package com.fuse.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fuse.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Collection<Person> findAll();

	Person findByUsername(String username);

}
