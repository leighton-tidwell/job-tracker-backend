package com.tdwldevelopment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tdwldevelopment.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, String> {
	
	@Query("{email:'?0'}")
	User findUserByEmail(String email);

	public long count();
}
