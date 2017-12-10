package com.fuse.login;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepository extends MongoRepository<Login, String> {

	public Login findByUsername(String username);

}