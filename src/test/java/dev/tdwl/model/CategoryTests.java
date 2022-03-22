package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTests {

    private final Category cat;

    public CategoryTests() {
        this.cat = new Category();
    }

    @BeforeEach
    void init() {
        List<Job> items = new ArrayList<>();
        Job testJob = new Job();
        testJob.setId("testJob");
        items.add(testJob);


        cat.setId("testId");
        cat.setCategory("testCat");
        cat.setItems(items);
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", cat.getId());
    }

    @Test
    void shouldSetId() {
        cat.setId("fooId");
        assertEquals("fooId", cat.getId());
    }

    @Test
    void shouldGetCategory() {
        assertEquals("testCat", cat.getCategory());
    }

    @Test
    void shouldSetCategory() {
        cat.setCategory("fooCat");
        assertEquals("fooCat", cat.getCategory());
    }

    @Test
    void shouldGetItems() {
        assertEquals(1, cat.getItems().size());
        assertEquals("testJob", cat.getItems().get(0).getId());
    }

    @Test
    void shouldSetItems() {
        List<Job> items = new ArrayList<>();
        Job testJob = new Job();
        testJob.setId("fooJob");

        Job testJobTwo = new Job();
        testJobTwo.setId("fooJobTwo");

        items.add(testJob);
        items.add(testJobTwo);

        cat.setItems(items);

        assertEquals(2, cat.getItems().size());
        assertEquals("fooJobTwo", cat.getItems().get(1).getId());
    }
}
