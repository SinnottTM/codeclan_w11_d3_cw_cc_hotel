import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest1;
    Guest guest2;
    Guest guest3;

    @Before
    public void setUp() {

        diningRoom = new DiningRoom("Subways Finest");

        guest1 = new Guest("Tim");
        guest2 = new Guest("Piotr");
        guest3 = new Guest("Dani");

    }

    @Test
    public void hasName(){
        assertEquals("Subways Finest", diningRoom.getDiningRoomName());
    }

    @Test
    public void canSetName(){
        diningRoom.setDiningRoomName("Papa Johns");
        assertEquals("Papa Johns", diningRoom.getDiningRoomName());
    }

    @Test
    public void canSetDiningRoomGuests(){
        ArrayList<Guest> testGuests = new ArrayList<>();
        testGuests.add(guest1);
        diningRoom.setNewGuestList(testGuests);
        assertEquals(testGuests, diningRoom.getGuests());
    }

    @Test
    public void diningRoomStartsEmpty(){
        assertEquals(0, diningRoom.getGuestCount());
    }

    @Test
    public void canCheckInGuests(){
        diningRoom.checkInGuest(guest1);
        assertEquals("Tim", diningRoom.getGuests().get(0).getName());
    }

    @Test
    public void canCheckOutGuests(){
        diningRoom.checkInGuest(guest1);
        diningRoom.checkInGuest(guest2);
        diningRoom.checkOutGuests();
        assertEquals(0, diningRoom.getGuestCount());
    }
}
