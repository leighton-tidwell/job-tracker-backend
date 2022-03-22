package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryListsTests {

    private final CategoryLists catList;

    public CategoryListsTests() {
        List<Category> list = new ArrayList<>();
        Category testCategory = new Category();
        testCategory.setId("testCategory");
        list.add(testCategory);

        this.catList = new CategoryLists("test", list);
    }

    @BeforeEach
    void init() {
        List<Category> list = new ArrayList<>();
        Category testCategory = new Category();
        testCategory.setId("testCategory");
        list.add(testCategory);

        catList.setId("testId");
        catList.setLists(list);
        catList.setUserId("testUser");
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", catList.getId());
    }

    @Test
    void shouldSetId() {
        catList.setId("fooId");
        assertEquals("fooId", catList.getId());
    }

    @Test
    void shouldGetUserId() {
        assertEquals("testUser", catList.getUserId());
    }

    @Test
    void shouldSetUserId() {
        catList.setUserId("fooUser");
        assertEquals("fooUser", catList.getUserId());
    }

    @Test
    void shouldGetCategoryList() {
        assertEquals(1, catList.getLists().size());
    }

    @Test
    void shouldSetCategoryList() {
        List<Category> list = new ArrayList<>();
        Category testCategory = new Category();
        testCategory.setId("fooTest");
        list.add(testCategory);

        Category testCategoryTwo = new Category();
        testCategoryTwo.setId("fooTestTwo");
        list.add(testCategoryTwo);

        catList.setLists(list);

        assertEquals(2, catList.getLists().size());
        assertEquals("fooTestTwo", catList.getLists().get(1).getId());
    }
}
