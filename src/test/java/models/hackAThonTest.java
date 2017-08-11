package models;

import static org.junit.Assert.*;
import org.junit.Test;

public class hackAThonTest {
    @Test
    public void placesYouveBeen_instantiatesCorrectly() throws Exception{
        hackAThon event = new hackAThon();
        assertEquals(true, event instanceof hackAThon);
    }
}