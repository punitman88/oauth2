package com.fuse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fuse.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByUsername(String username);

}
