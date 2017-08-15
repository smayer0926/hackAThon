package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
     @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
        Team.clearAllTeams();
    }
    @Test
    public void Team_instantiatesCorrectly_true() throws Exception {
        Team testTeam = new Team("PDX", "name");
        assertEquals(true, testTeam instanceof Team);
    }
    @Test
    public void getTeamName_teamInstantiatesWithName_PDX() throws Exception {
        Team testTeam = new Team("PDX", "name");
        assertEquals("PDX", testTeam.getNameOfTeam());
    }
    @Test
    public void all_returnsAllTeams_2() throws Exception {
        Team one = new Team("PDX", "name");
        Team two = new Team("Ducks", "name");
        assertEquals(2, Team.getAllTeams().size());
    }
    @Test
    public void getTeamId_teamInstantiatesWithanId() throws Exception {
        Team testTeam = new Team ("PDX", "name");
        assertEquals(3, testTeam.getId());
    }
    public void findReturnsCorrectName() throws Exception {
        Team testTeam = newTeam();
        assertEquals(1, Team.findbyId(testTeam.getId()).getId());
    }

    @Test
    public void clearMembersfromTeam_0() throws Exception {
         Team testTeam = newTeam();
         Team newTeam = new Team("Seattle", "new");
         testTeam.setMembers("New", "new");
         Team.clearAllTeams();
         assertEquals(0, Team.getAllTeams().size());
    }

    @Test
    public void Team_CreatesUniqueID_() throws Exception {
        Team.clearAllTeams();
        Team testTeam = newTeam();
        Team newTeam = new Team("Seattle", "new");
        assertEquals(7, newTeam.getId());
    }
    @Test
    public void updateChangestoTeamContent() throws Exception {
        Team testTeam = newTeam();
        String formerContent = testTeam.getNameOfTeam();
        int formerId = testTeam.getId();

        testTeam.update("Android: Day 40");

        assertEquals(formerId, testTeam.getId());
        assertNotEquals(formerContent, testTeam.getNameOfTeam());
    }
    //Helpers
    public Team newTeam() {
        return new Team("PDX", "name");
    }
}
