package com.tdwldevelopment.jobtracker;

import com.tdwldevelopment.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"com.tdwldevelopment.repository", "com.tdwldevelopment.controller"})
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class JobTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
    }

}
