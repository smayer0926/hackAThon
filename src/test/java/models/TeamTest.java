package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    @After
    public void tearDown () throws Exception {
        Team.clearAllTeams();
    }
    @Before
    public void setUp() throws Exception {
    }
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

    @Test
    public void all_returnsAllTeams_2() throws Exception {
        Team one = new Team("PDX");
        Team two = new Team("Ducks");
        assertEquals(2, Team.getAllTeams().size());
    }

    @Test
    public void getTeamId_teamInstantiatesWithanId() throws Exception {
        Team testTeam = new Team ("PDX");
        assertEquals(1, testTeam.getTeamId());
    }
    public void findReturnsCorrectName() throws Exception {
        Team testTeam = newTeam();
        assertEquals(1, Team.findById(testTeam.getTeamId()).getTeamId());
    }
    @Test
    public void findReturnsCorrectTeamWhenMoreThanOneNameExists() throws Exception {

        Team testTeam = newTeam();
        Team otherTeam = new Team("Ducks");
        assertEquals(2, Team.findById(otherTeam.getTeamId()).getTeamId());
    }

    //Helpers
    public Team newTeam() {
        return new Team("PDX");
    }
}