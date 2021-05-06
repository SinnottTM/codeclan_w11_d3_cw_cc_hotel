import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom1;
    private Bedroom bedroom2;

    private Guest guest1;
    private Guest guest2;

    private ArrayList<Guest> guests1;

    @Before
    public void before(){
        guest1 = new Guest("Tim");
        guest2 = new Guest("Piotr");

        bedroom1 = new Bedroom(1, 2, "Double", 50);
        bedroom2 = new Bedroom(2, 4, "Family", 75);

        guests1 = new ArrayList<>();
        guests1.add(guest1);
        guests1.add(guest2);

    }

    @Test
    public void hasNumber(){
        assertEquals(1, bedroom1.getNumber());
    }

    @Test
    public void canSetNumber(){
        bedroom1.setNumber(2);
        assertEquals(2, bedroom1.getNumber());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, bedroom1.getCapacity());
    }

    @Test
    public void canSetCapacity(){
        bedroom1.setCapacity(3);
        assertEquals(3, bedroom1.getCapacity());
    }

    @Test
    public void hasGuests(){
        ArrayList<Guest> emptyTestGuests = new ArrayList<>();
        assertEquals(emptyTestGuests, bedroom1.getGuests());
    }

//  ArrayList issue (location in memory), complex solution (see canAddGuestsNameCheck for simple)
    @Test
    public void canSetGuests(){
        Guest testGuest = new Guest("Timothy Sinnott");
        ArrayList<Guest> testGuests = new ArrayList<>();
        testGuests.add(testGuest);
        bedroom1.setGuests(testGuests);
        assertEquals(testGuests, bedroom1.getGuests());
    }

    @Test
    public void hasType(){
        assertEquals("Double", bedroom1.getType());
    }

    @Test
    public void canSetType(){
        bedroom1.setType("Family");
        assertEquals("Family", bedroom1.getType());
    }

    @Test
    public void hasNightlyRate(){
        assertEquals(50, bedroom1.getNightlyRate(), 0.01);
    }

    @Test
    public void canSetNightlyRate(){
        bedroom1.setNightlyRate(60);
        assertEquals(60, bedroom1.getNightlyRate(), 0.01);

    }

//  Avoids ArrayList issue for comparison (see canSetGuests for more complex version)
    @Test
    public void canAddGuests(){
        bedroom1.checkInGuestIndividual(guest1);
        assertEquals("Tim", bedroom1.getGuests().get(0).getName());
    }

    @Test
    public void canRemoveGuest(){
        bedroom1.checkInGuestIndividual(guest1);
        bedroom1.checkInGuestIndividual(guest2);
        bedroom1.checkOutGuestIndividual(guest1);
        assertEquals(guest2, bedroom1.getGuests().get(0));
    }

    @Test
    public void canAddGuestsAll(){
        bedroom1.checkInGuestsAll(guests1);
        assertEquals("Tim", bedroom1.getGuests().get(0).getName());
    }

    @Test
    public void canCountRoomGuests(){
        bedroom1.checkInGuestIndividual(guest1);
        bedroom1.checkInGuestIndividual(guest2);
        assertEquals(bedroom1.getGuestCount(), 2);
    }

    @Test
    public void canRemoveGuestsAll(){
        bedroom1.checkInGuestsAll(guests1);
        bedroom1.checkOutGuestsAll();
        assertEquals(0, bedroom1.getGuestCount());
    }
}
