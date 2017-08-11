package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class memberTest {
    @After
    public void tearDown () throws Exception {
        Member.clearAllEvents();
    }
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void hackAThon_instantiatesCorrectly() throws Exception{
        Member event = new Member("Jim", 20, "dude");
        assertEquals(true, event instanceof Member);
    }
    @Test
    public void hackAThon_entryInstantiatesWithContent_Jim() throws Exception {
        Member event = new Member("Jim", 20, "dude");
        assertEquals("Jim", event.getName());
    }
    @Test
    public void hackAThon_entryReturnsContent_1() throws Exception {
        Member event = new Member("Jim", 20, "dude");
        assertEquals(1, event.getAllEvents().size());
    }
    @Test
    public void getId_eventInstantiatesWithAnID_1() throws Exception {
        Member.clearAllEvents();
        Member myEvent = new Member("Jim", 20, "dude");
        assertEquals(1, myEvent.getId());
    }
    @Test
    public void findReturnsCorrectName() throws Exception {
        Member event = newEvents();
        assertEquals(1, Member.findById(event.getId()).getId());
    }

    @Test
    public void findReturnsCorrectMemberWhenMoreThanOneNameExists() throws Exception {
        Member event = newEvents();
        Member otherEvent = new Member("Jim", 20, "dude");
        assertEquals(2, Member.findById(otherEvent.getId()).getId());
    }

    @Test
    public void updateChangestoMemberContent() throws Exception {
        Member event = newEvents();
        String formerContent = event.getName();
        int formerAge = event.getAge();
        String formerDescription = event.getDescription();

        int formerId = event.getId();

        event.update("Android: Day 40", 30, "guy");

        assertEquals(formerId, event.getId());
        assertNotEquals(formerContent, event.getName());
        assertNotEquals(formerAge, event.getAge());
        assertNotEquals(formerDescription, event.getDescription());
    }

    //Helpers
    public Member newEvents() {
        return new Member("Bob", 20, "dude");
    }
}