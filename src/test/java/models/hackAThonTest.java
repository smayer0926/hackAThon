package models;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class hackAThonTest {
    @After
    public void tearDown () throws Exception {
        hackAThon.clearAllEvents();
    }
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void hackAThon_instantiatesCorrectly() throws Exception{
        hackAThon event = new hackAThon("Jim");
        assertEquals(true, event instanceof hackAThon);
    }

    @Test
    public void hackAThon_entryInstantiatesWithContent_Jim() throws Exception {
        hackAThon event = new hackAThon("Jim");
        assertEquals("Jim", event.getName());
    }

    @Test
    public void hackAThon_entryReturnsContent_1() throws Exception {
        hackAThon event = new hackAThon("Jim");
        assertEquals(1, event.getAllEvents().size());
    }
}