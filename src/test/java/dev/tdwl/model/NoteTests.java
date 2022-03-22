package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTests {

    private final Note note;

    public NoteTests() {
        this.note = new Note();
    }

    @BeforeEach
    void init() {
        note.setText("testText");
    }

    @Test
    void shouldGetText() {
        assertEquals("testText", note.getText());
    }

    @Test
    void shouldSetText() {
        note.setText("fooText");
        assertEquals("fooText", note.getText());
    }
}
