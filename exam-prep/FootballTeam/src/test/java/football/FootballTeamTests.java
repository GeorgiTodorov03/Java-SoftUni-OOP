package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FootballTeamTests {

    private static final String PLAYER_NAME = "Pesho";
    private static final String TEAM_NAME = "Pesho's team";


    private Footballer footballer;

    private FootballTeam footballTeam;

    @Before
    public void setUp() {
        this.footballer = new Footballer(PLAYER_NAME);
        this.footballTeam = new FootballTeam(TEAM_NAME, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatingTeamWithNoPositions() {
        new FootballTeam("test_name", - 1);
    }

    @Test
    public void testCreatingTeamWithPositions() {
        assertEquals(10, footballTeam.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsItEmpty() {
        new FootballTeam("    ", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameIsItNull() {
        new FootballTeam(null, 10);
    }

    @Test
    public void testSetNameIsWorking() {
        assertEquals(PLAYER_NAME, footballer.getName());
    }

    @Test
    public void testAddPlayersIncrease() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerFailWhenNoSpace() {
        FootballTeam team = new FootballTeam(TEAM_NAME, 0);
        team.addFootballer(footballer);
    }

    @Test
    public void testRemovePlayerSuccessfully() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());

        footballTeam.removeFootballer(PLAYER_NAME);
        assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePLayerThrowsException() {
        footballTeam.addFootballer(footballer);

        footballTeam.removeFootballer("Gosho");
    }

    @Test
    public void testFootballForSaleShouldDeactivate() {
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());

        footballTeam.footballerForSale(footballer.getName());
        assertFalse(footballer.isActive());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleShouldFail() {
        footballTeam.addFootballer(footballer);

        footballTeam.removeFootballer("Gosho");
    }
}
