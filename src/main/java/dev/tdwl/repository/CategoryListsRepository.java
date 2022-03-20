package dev.tdwl.repository;

import dev.tdwl.model.CategoryLists;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CategoryListsRepository extends MongoRepository<CategoryLists, String> {

    @Query("{userId:'?0'}")
    CategoryLists findListsById(String userId);

    long count();
}
