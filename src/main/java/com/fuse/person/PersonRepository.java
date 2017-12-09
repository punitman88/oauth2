package com.fuse.person;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

	Collection<Person> findAll();

	Person findByUsername(String username);

}
