package dev.tdwl.model;

import java.util.List;

public class Category {

    private String id;

    private String category;

    private List<Job> items;

    public List<Job> getItems() {
        return items;
    }

    public void setItems(List<Job> items) {
        this.items = items;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
