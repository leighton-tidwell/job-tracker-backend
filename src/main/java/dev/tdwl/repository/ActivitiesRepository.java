package dev.tdwl.repository;

import dev.tdwl.model.Activities;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ActivitiesRepository extends MongoRepository<Activities, String> {

    @Query("{jobId:'?0'}")
    Activities findActivitiesByJobId(String jobId);

    long count();
}