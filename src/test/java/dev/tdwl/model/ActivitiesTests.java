package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivitiesTests {
    private final Activities activities;

    public ActivitiesTests() {
        List<Activity> activityList = new ArrayList<>();
        Activity testActivity = new Activity();
        testActivity.setId("newActivity");
        activityList.add(testActivity);

        this.activities = new Activities("job", "user", activityList);
        activities.setId("foo");
    }

    @BeforeEach
    void init() {
        activities.setId("foo");
        activities.setUserId("user");
        activities.setJobId("job");
    }

    @Test
    void shouldGetId() {
        assertEquals("foo", activities.getId());
    }

    @Test
    void shouldSetId() {
        activities.setId("newTest");
        assertEquals("newTest", activities.getId());
    }

    @Test
    void shouldGetUserId() {
        assertEquals("user", activities.getUserId());
    }

    @Test
    void shouldSetUserId() {
        activities.setUserId("testUserId");
        assertEquals("testUserId", activities.getUserId());
    }

    @Test
    void shouldGetJobId() {
        assertEquals("job", activities.getJobId());
    }

    @Test
    void shouldSetJobId() {
        activities.setJobId("testJobId");
        assertEquals("testJobId", activities.getJobId());
    }

    @Test
    void shouldGetActivities() {
        assertEquals(1, activities.getActivities().size());
        assertEquals("newActivity", activities.getActivities().get(0).getId());
    }

    @Test
    void shouldSetActivities() {
        Activity testActivity = new Activity();
        testActivity.setId("testActivity");

        Activity testActivityTwo = new Activity();
        testActivityTwo.setId("testActivity2");

        List<Activity> activityList = new ArrayList<>();

        activityList.add(testActivity);
        activityList.add(testActivityTwo);
        activities.setActivities(activityList);

        assertEquals(2, activities.getActivities().size());
        assertEquals("testActivity", activities.getActivities().get(0).getId());
        assertEquals("testActivity2", activities.getActivities().get(1).getId());
    }

}
