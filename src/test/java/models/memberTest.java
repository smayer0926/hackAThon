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
        Member event = new Member("Jim");
        assertEquals(true, event instanceof Member);
    }
    @Test
    public void hackAThon_entryInstantiatesWithContent_Jim() throws Exception {
        Member event = new Member("Jim");
        assertEquals("Jim", event.getName());
    }
    @Test
    public void hackAThon_entryReturnsContent_1() throws Exception {
        Member event = new Member("Jim");
        assertEquals(1, event.getAllEvents().size());
    }
    @Test
    public void getId_eventInstantiatesWithAnID_1() throws Exception {
        Member.clearAllEvents();
        Member myEvent = new Member("Jim");
        assertEquals(1, myEvent.getParticpantId());
    }
    @Test
    public void findReturnsCorrectName() throws Exception {
        Member event = newEvents();
        assertEquals(1, Member.findById(event.getParticpantId()).getParticpantId());
    }

    @Test
    public void findReturnsCorrectMemberWhenMoreThanOneNameExists() throws Exception {
        Member event = newEvents();
        Member otherEvent = new Member("Bob");
        assertEquals(2, Member.findById(otherEvent.getParticpantId()).getParticpantId());
    }

    @Test
    public void updateChangestoMemberContent() throws Exception {
        Member event = newEvents();
        String formerContent = event.getName();
        int formerId = event.getParticpantId();

        event.update("Android: Day 40");

        assertEquals(formerId, event.getParticpantId());
        assertNotEquals(formerContent, event.getName());
    }

    //Helpers
    public Member newEvents() {
        return new Member("Jim");
    }
}