package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotesTests {

    private final Notes notes;

    public NotesTests() {
        List<Note> list = new ArrayList<>();
        Note testNote = new Note();
        testNote.setText("testText");
        list.add(testNote);

        this.notes = new Notes("testJob", list);
    }

    @BeforeEach
    void init() {
        List<Note> list = new ArrayList<>();
        Note testNote = new Note();
        testNote.setText("testText");
        list.add(testNote);

        notes.setUserId("testUser");
        notes.setId("testId");
        notes.setJobId("testJob");
        notes.setNotes(list);
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", notes.getId());
    }

    @Test
    void shouldSetId() {
        notes.setId("fooId");
        assertEquals("fooId", notes.getId());
    }

    @Test
    void shouldGetUserId() {
        assertEquals("testUser", notes.getUserId());
    }

    @Test
    void shouldSetUserId() {
        notes.setUserId("fooUser");
        assertEquals("fooUser", notes.getUserId());
    }

    @Test
    void shouldGetJobId() {
        assertEquals("testJob", notes.getJobId());
    }

    @Test
    void shouldSetJobId() {
        notes.setJobId("fooJob");
        assertEquals("fooJob", notes.getJobId());
    }

    @Test
    void shouldGetNotes() {
        assertEquals(1, notes.getNotes().size());
    }

    @Test
    void shouldSetNotes() {
        List<Note> list = new ArrayList<>();
        Note testNote = new Note();
        testNote.setText("testText");
        list.add(testNote);

        Note testNoteTwo = new Note();
        testNoteTwo.setText("testTextTwo");
        list.add(testNoteTwo);

        notes.setNotes(list);

        assertEquals(2, notes.getNotes().size());
        assertEquals("testTextTwo", notes.getNotes().get(1).getText());
    }
}
