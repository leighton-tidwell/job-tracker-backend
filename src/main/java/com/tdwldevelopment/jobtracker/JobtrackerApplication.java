package com.tdwldevelopment.jobtracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdwldevelopment.model.User;
import com.tdwldevelopment.repository.UserRepository;

@RestController
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class JobtrackerApplication {

	@Autowired
	UserRepository userRepo;
	
	@RequestMapping(value = "/")
	public List<User> getUsers() {
		userRepo.save(new User("leighton-tidwell", "leighton.tidwell@email.com"));
		return userRepo.findAll();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(JobtrackerApplication.class, args);
	}

}
