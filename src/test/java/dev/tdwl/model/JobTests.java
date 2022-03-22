package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobTests {

    private final Job job;

    public JobTests() {
        this.job = new Job();
    }

    @BeforeEach
    void init() {
        job.setId("testId");
        job.setCompany("testCompany");
        job.setColor("testColor");
        job.setLocation("testLocation");
        job.setDescription("testDescription");
        job.setPostUrl("testUrl");
        job.setTitle("testTitle");
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", job.getId());
    }

    @Test
    void shouldSetId() {
        job.setId("fooId");
        assertEquals("fooId", job.getId());
    }

    @Test
    void shouldGetCompany() {
        assertEquals("testCompany", job.getCompany());
    }

    @Test
    void shouldSetCompany() {
        job.setCompany("fooJob");
        assertEquals("fooJob", job.getCompany());
    }

    @Test
    void shouldGetColor() {
        assertEquals("testColor", job.getColor());
    }

    @Test
    void shouldSetColor() {
        job.setColor("fooColor");
        assertEquals("fooColor", job.getColor());
    }

    @Test
    void shouldGetLocation() {
        assertEquals("testLocation", job.getLocation());
    }

    @Test
    void shouldSetLocation() {
        job.setLocation("fooLocation");
        assertEquals("fooLocation", job.getLocation());
    }

    @Test
    void shouldGetDescription() {
        assertEquals("testDescription", job.getDescription());
    }

    @Test
    void shouldSetDescription() {
        job.setDescription("fooDescription");
        assertEquals("fooDescription", job.getDescription());
    }

    @Test
    void shouldGetPostUrl() {
        assertEquals("testUrl", job.getPostUrl());
    }

    @Test
    void shouldSetPostUrl() {
        job.setPostUrl("fooUrl");
        assertEquals("fooUrl", job.getPostUrl());
    }

    @Test
    void shouldGetTitle() {
        assertEquals("testTitle", job.getTitle());
    }

    @Test
    void shouldSetTitle() {
        job.setTitle("fooTitle");
        assertEquals("fooTitle", job.getTitle());
    }
}
