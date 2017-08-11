package models;

import static org.junit.Assert.*;
import org.junit.Test;

public class hackAThonTest {
    @Test
    public void hackAThon_instantiatesCorrectly() throws Exception{
        hackAThon event = new hackAThon();
        assertEquals(true, event instanceof hackAThon);
    }

    @Test
    public void hackAThon_entryInstantiatesWithConent_Name() throws Exception {
        hackAThon event = new hackAThon("Jim");
        assertEquals("Jim", event.getName());
    }
}