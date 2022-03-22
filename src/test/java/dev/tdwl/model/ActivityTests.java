package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityTests {
    private final Activity activity;

    public ActivityTests() {
        this.activity = new Activity();
    }

    @BeforeEach
    void init() {
        activity.setId("testId");
        activity.setCompleted(false);
        activity.setEndDate("ISOSTRING");
        activity.setStartDate("ISOSTRING");
        activity.setTitle("testTitle");
        activity.setNote("testNote");
        activity.setType("testType");
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", activity.getId());
    }

    @Test
    void shouldSetId() {
        activity.setId("fooBar");
        assertEquals("fooBar", activity.getId());
    }

    @Test
    void shouldGetCompleted() {
        assertEquals(false, activity.getCompleted());
    }

    @Test
    void shouldSetCompleted() {
        activity.setCompleted(true);
        assertEquals(true, activity.getCompleted());
    }

    @Test
    void shouldGetEndDate() {
        assertEquals("ISOSTRING", activity.getEndDate());
    }

    @Test
    void shouldSetEndDate() {
        activity.setEndDate("ENDDATE");
        assertEquals("ENDDATE", activity.getEndDate());
    }

    @Test
    void shouldGetStartDate() {
        assertEquals("ISOSTRING", activity.getStartDate());
    }

    @Test
    void shouldSetStartDate() {
        activity.setStartDate("STARTDATE");
        assertEquals("STARTDATE", activity.getStartDate());
    }

    @Test
    void shouldGetTitle() {
        assertEquals("testTitle", activity.getTitle());
    }

    @Test
    void shouldSetTitle() {
        activity.setTitle("fooTitle");
        assertEquals("fooTitle", activity.getTitle());
    }

    @Test
    void shouldGetNote() {
        assertEquals("testNote", activity.getNote());
    }

    @Test
    void shouldSetNote() {
        activity.setNote("fooNote");
        assertEquals("fooNote", activity.getNote());
    }

    @Test
    void shouldGetType() {
        assertEquals("testType", activity.getType());
    }

    @Test
    void shouldSetType() {
        activity.setType("fooType");
        assertEquals("fooType", activity.getType());
    }


}
