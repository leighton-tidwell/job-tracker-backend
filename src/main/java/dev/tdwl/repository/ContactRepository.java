package dev.tdwl.repository;

import dev.tdwl.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {

    @Query("{id:'?0'}")
    Contact findContactById(String id);

    @Query("{userId:'?0'}")
    List<Contact> findContactsByUserId(String userId);

    @Query("{jobId:'?0'}")
    List<Contact> findContactsByJobId(String jobId);

    long count();
}