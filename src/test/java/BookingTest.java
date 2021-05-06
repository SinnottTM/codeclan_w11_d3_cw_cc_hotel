import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    private Bedroom bedroom1;
    private Bedroom bedroom2;

    private Booking booking;


    @Before
    public void before(){
        guest1 = new Guest("Tim");
        guest2 = new Guest("Piotr");
        guest3 = new Guest("Dani");

        bedroom1 = new Bedroom(1, 2, "Double", 50);
        bedroom2 = new Bedroom(2, 4, "Family", 75);

        booking = new Booking (bedroom1, 2);
    }

    @Test
    public void hasBedroom(){
        assertEquals(bedroom1, booking.getBedroom());
    }

    @Test
    public void canSetBedroom(){
        booking.setBedroom(bedroom2);
        assertEquals(bedroom2, booking.getBedroom());
    }

    @Test
    public void hasNightsBooked(){
        assertEquals(2, booking.getNightsBooked());
    }

    @Test
    public void canSetNightsBooked(){
        booking.setNightsBooked(3);
        assertEquals(3, booking.getNightsBooked());
    }

    @Test
    public void canGenerateNightlyBill(){
        booking.setNightsBooked(3);
        assertEquals(150 ,booking.getTotalBill(), 0.01);
    }
}
