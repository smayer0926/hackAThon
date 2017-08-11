package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void Team_instantiatesCorrectly_true() throws Exception {
        Team testTeam = new Team("PDX");
        assertEquals(true, testTeam instanceof Team);
    }
    @Test
    public void getTeamName_teamInstantiatesWithName_PDX() throws Exception {
        Team testTeam = new Team("PDX");
        assertEquals("PDX", testTeam.getNameOfTeam());
    }
}