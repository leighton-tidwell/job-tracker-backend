package dev.tdwl.jobtracker;

import dev.tdwl.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = {"dev.tdwl.repository", "dev.tdwl.controller", "dev.tdwl.services", "dev.tdwl.security"})
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
public class JobTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
    }

}
