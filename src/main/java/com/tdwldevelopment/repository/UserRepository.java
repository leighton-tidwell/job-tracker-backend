package com.tdwldevelopment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tdwldevelopment.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	@Query("{name:'?0'}")
	User findUserByName(String name);
	
	
	public long count();
}
