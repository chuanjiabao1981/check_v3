package com.check.v3.repository;

import org.springframework.data.repository.CrudRepository;

import com.check.v3.domain.User;

public interface UserRepository extends CrudRepository<User,Long>{
	public User findByAccount(String account);
}
