package dev.tdwl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("categories")
public class CategoryLists {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userId;

    private List<Category> lists;

    public CategoryLists(String userId, List<Category> lists) {
        super();
        this.userId = userId;
        this.lists = lists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Category> getLists() {
        return lists;
    }

    public void setLists(List<Category> lists) {
        this.lists = lists;
    }
}
