import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom1;
    private ConferenceRoom conferenceRoom2;

    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    @Before
    public void before(){
        conferenceRoom1 = new ConferenceRoom("Oak Suite", 25);
        conferenceRoom2 = new ConferenceRoom("Elm Suite", 50);

        guest1 = new Guest("Tim");
        guest2 = new Guest("Piotr");
        guest3 = new Guest("Dani");

    }

    @Test
    public void hasName(){
        assertEquals("Oak Suite", conferenceRoom1.getName());
    }

    @Test
    public void canSetName(){
        conferenceRoom1.setName("Ash Suite");
        assertEquals("Ash Suite", conferenceRoom1.getName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(25, conferenceRoom1.getCapacity());
    }

    @Test
    public void canSetCapacity(){
        conferenceRoom1.setCapacity(30);
        assertEquals(30, conferenceRoom1.getCapacity());
    }

    @Test
    public void hasGuests(){
        ArrayList<Guest> emptyTestGuests = new ArrayList<>();
        assertEquals(emptyTestGuests, conferenceRoom1.getGuests());
    }

//  ArrayList issue (location in memory), complex solution (see canAddGuestsNameCheck for simple)
    @Test
    public void canSetGuests(){
        Guest testGuest = new Guest("Timothy Sinnott");
        ArrayList<Guest> testGuests = new ArrayList<>();
        testGuests.add(testGuest);
        conferenceRoom1.setGuests(testGuests);
        assertEquals(testGuests, conferenceRoom1.getGuests());
    }

    //  Avoids ArrayList issue for comparison (see canSetGuests for more complex version)
    @Test
    public void canAddGuests(){
        conferenceRoom1.checkInGuestIndividual(guest1);
        assertEquals("Tim", conferenceRoom1.getGuests().get(0).getName());
    }

    @Test
    public void canRemoveGuest(){
        conferenceRoom1.checkInGuestIndividual(guest1);
        conferenceRoom1.checkInGuestIndividual(guest2);
        conferenceRoom1.checkOutGuestIndividual(guest1);
        assertEquals(guest2, conferenceRoom1.getGuests().get(0));
    }

    @Test
    public void canRemoveAllGuest(){
        conferenceRoom1.checkInGuestIndividual(guest1);
        conferenceRoom1.checkInGuestIndividual(guest2);
        conferenceRoom1.checkOutGuests();
        assertEquals(0, conferenceRoom1.getGuestCount());
    }

    @Test
    public void canCountRoomGuests(){
        conferenceRoom1.checkInGuestIndividual(guest1);
        conferenceRoom1.checkInGuestIndividual(guest2);
        assertEquals(conferenceRoom1.getGuestCount(), 2);
    }

}
