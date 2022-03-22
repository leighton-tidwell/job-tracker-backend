package dev.tdwl.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTests {

    private final Contact contact;

    public ContactTests() {
        this.contact = new Contact("testUser", "testJob", "testName", "testPosition", "testCompany", "testLocation", "testEmail", "testPhone");
    }

    @BeforeEach
    void init() {
        contact.setId("testId");
        contact.setUserId("testUser");
        contact.setJobId("testJob");
        contact.setName("testName");
        contact.setPosition("testPosition");
        contact.setCompany("testCompany");
        contact.setLocation("testLocation");
        contact.setEmail("testEmail");
        contact.setPhone("testPhone");
    }

    @Test
    void shouldGetId() {
        assertEquals("testId", contact.getId());
    }

    @Test
    void shouldSetId() {
        contact.setId("fooId");
        assertEquals("fooId", contact.getId());
    }

    @Test
    void shouldGetUserId() {
        assertEquals("testUser", contact.getUserId());
    }

    @Test
    void shouldSetUserId() {
        contact.setUserId("fooUser");
        assertEquals("fooUser", contact.getUserId());
    }

    @Test
    void shouldGetJobId() {
        assertEquals("testJob", contact.getJobId());
    }

    @Test
    void shouldSetJobId() {
        contact.setJobId("fooJob");
        assertEquals("fooJob", contact.getJobId());
    }

    @Test
    void shouldGetName() {
        assertEquals("testName", contact.getName());
    }

    @Test
    void shouldSetName() {
        contact.setName("fooName");
        assertEquals("fooName", contact.getName());
    }

    @Test
    void shouldGetPosition() {
        assertEquals("testPosition", contact.getPosition());
    }

    @Test
    void shouldSetPosition() {
        contact.setPosition("fooPosition");
        assertEquals("fooPosition", contact.getPosition());
    }

    @Test
    void shouldGetCompany() {
        assertEquals("testCompany", contact.getCompany());
    }

    @Test
    void shouldSetCompany() {
        contact.setCompany("fooCompany");
        assertEquals("fooCompany", contact.getCompany());
    }

    @Test
    void shouldGetLocation() {
        assertEquals("testLocation", contact.getLocation());
    }

    @Test
    void shouldSetLocation() {
        contact.setLocation("fooLocation");
        assertEquals("fooLocation", contact.getLocation());
    }

    @Test
    void shouldGetEmail() {
        assertEquals("testEmail", contact.getEmail());
    }

    @Test
    void shouldSetEmail() {
        contact.setEmail("fooEmail");
        assertEquals("fooEmail", contact.getEmail());
    }

    @Test
    void shouldGetPhone() {
        assertEquals("testPhone", contact.getPhone());
    }

    @Test
    void shouldSetPhone() {
        contact.setPhone("fooPhone");
        assertEquals("fooPhone", contact.getPhone());
    }

}
