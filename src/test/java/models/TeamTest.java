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

    @Test
    public void all_returnsAllTeams_2() throws Exception {
        Team.clear();
        Team one = new Team("PDX");
        Team two = new Team("Ducks");
        assertEquals(2, Team.getAllTeams().size());
    }

    @Test
    public void getTeamId_teamInstantiatesWithanId() throws Exception {
        Team.clear();
        Team testTeam = new Team ("PDX");
        assertEquals(1, testTeam.getTeamId());
    }
    public void findReturnsCorrectName() throws Exception {
        Team testTeam = newTeam();
        assertEquals(1, Team.findById(testTeam.getTeamId()).getTeamId());
    }

    //Helpers
    public Team newTeam() {
        return new Team("PDX");
    }
}