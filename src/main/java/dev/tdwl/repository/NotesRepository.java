package dev.tdwl.repository;

import dev.tdwl.model.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface NotesRepository extends MongoRepository<Notes, String> {

    @Query("{jobId:'?0'}")
    Notes findNotesByJobId(String id);

    @Query("{userId:'?0'}")
    Notes findNotesByUserId(String Id);

    long count();
}
