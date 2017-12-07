package com.fuse.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fuse.model.Party;

@Repository
public interface PartyRepository extends CrudRepository<Party, Long> {

	Collection<Party> findAll();

}
