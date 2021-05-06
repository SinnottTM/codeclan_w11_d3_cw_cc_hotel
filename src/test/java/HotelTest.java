import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class HotelTest {

    private Hotel hotel1;

    private Bedroom bedroom1;
    private Bedroom bedroom2;

    private ConferenceRoom conferenceRoom1;
    private ConferenceRoom conferenceRoom2;

    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    private Booking booking1;

    private DiningRoom diningRoom1;


    @Before
    public void before(){
        hotel1 = new Hotel("The Grand Budapest");

        bedroom1 = new Bedroom(1, 2, "Double", 50);
        bedroom2 = new Bedroom(2, 4, "Family", 75);

        conferenceRoom1 = new ConferenceRoom("Oak Suite", 25);
        conferenceRoom2 = new ConferenceRoom("Elm Suite", 50);

        guest1 = new Guest("Tim");
        guest2 = new Guest("Piotr");
        guest3 = new Guest("Dani");

        booking1 = new Booking (bedroom1, 2);

        diningRoom1 = new DiningRoom("Subways Finest");

    }

    @Test
    public void hasName(){
        assertEquals("The Grand Budapest", hotel1.getName());
    }

    @Test
    public void canSetName(){
        hotel1.setName("The Not So Grand Budapest");
        assertEquals("The Not So Grand Budapest", hotel1.getName());
    }

    @Test
    public void hasGuestsBedroom(){
        ArrayList<Guest> emptyTestGuests = new ArrayList<>();
        assertEquals(emptyTestGuests, hotel1.getBedrooms());
    }

    @Test
    public void canSetGuestsBedroom(){
        ArrayList<Bedroom> testBedrooms = new ArrayList<>();
        testBedrooms.add(bedroom1);
        hotel1.setBedrooms(testBedrooms);
        assertEquals(testBedrooms, hotel1.getBedrooms());
    }

    @Test
    public void hasGuestsConferenceRoom(){
        ArrayList<Guest> emptyTestGuests = new ArrayList<>();
        assertEquals(emptyTestGuests, hotel1.getConferenceRooms());
    }

    @Test
    public void canSetGuestsConferenceRoom(){
        ArrayList<ConferenceRoom> testConferenceRoom = new ArrayList<>();
        testConferenceRoom.add(conferenceRoom1);
        hotel1.setConferenceRooms(testConferenceRoom);
        assertEquals(testConferenceRoom, hotel1.getConferenceRooms());
    }

    @Test
    public void hasDiningRoom(){
        HashMap<String, DiningRoom> testDiningRoom = new HashMap<>();
        assertEquals(testDiningRoom, hotel1.getDiningRooms());
    }

    @Test
    public void canSetDiningRoom(){
        HashMap<String, DiningRoom> testDiningRoom = new HashMap<>();
        testDiningRoom.put("First", diningRoom1);
        assertEquals("Subways Finest", diningRoom1.getDiningRoomName());
    }

    @Test
    public void canAddBedroomRoom(){
        hotel1.addBedroom(bedroom1);
        assertEquals(bedroom1, hotel1.getBedrooms().get(0));
    }

    @Test
    public void canRemoveBedroom(){
        hotel1.addBedroom(bedroom1);
        hotel1.addBedroom(bedroom2);
        hotel1.removeBedroom(bedroom1);
        assertEquals(bedroom2, hotel1.getBedrooms().get(0));
    }

    @Test
    public void canAddConferenceRoom(){
        hotel1.addConference(conferenceRoom1);
        assertEquals(conferenceRoom1, hotel1.getConferenceRooms().get(0));
    }

    @Test
    public void canRemoveConferenceRoom(){
        hotel1.addConference(conferenceRoom1);
        hotel1.addConference(conferenceRoom2);
        hotel1.removeConference(conferenceRoom1);
        assertEquals(conferenceRoom2, hotel1.getConferenceRooms().get(0));
    }

    @Test
    public void canCheckInGuestsBedroom(){
        hotel1.checkInGuestBedroom(guest1, bedroom1);
        assertEquals("Tim", bedroom1.getGuests().get(0).getName());
    }

    @Test
    public void canCheckOutGuestsBedroom(){
        hotel1.checkInGuestBedroom(guest1, bedroom1);
        hotel1.checkInGuestBedroom(guest2, bedroom1);
        hotel1.checkOutGuestBedroom(guest1, bedroom1);
        assertEquals(guest2, bedroom1.getGuests().get(0));
    }

    @Test
    public void canCheckInGuestsConference(){
        hotel1.checkInGuestConference(guest1, conferenceRoom1);
        assertEquals("Tim", conferenceRoom1.getGuests().get(0).getName());
    }

    @Test
    public void canCheckOutGuestsConference(){
        hotel1.checkInGuestConference(guest1, conferenceRoom1);
        hotel1.checkInGuestConference(guest2, conferenceRoom1);
        hotel1.checkOutGuestConference(guest1, conferenceRoom1);
        assertEquals(guest2, conferenceRoom1.getGuests().get(0));
    }

    @Test
    public void canBookRoom(){
        hotel1.addBedroom(bedroom1);
        Booking hotelBooking = hotel1.bookRoom(bedroom1, 2);
        assertEquals(booking1.getNightsBooked(), hotelBooking.getNightsBooked());
        assertEquals(booking1.getBedroom(), hotelBooking.getBedroom());
    }

    @Test
    public void canCheckGuestsIntoBedroom() {
        hotel1.addBedroom(bedroom1);
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        hotel1.checkInGuestsToBedroom(1, guests);
        assertEquals(1, bedroom1.getGuestCount());

    }

    @Test
    public void cantCheckGuestsIntoBedroom() {
        hotel1.addBedroom(bedroom1);
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        guests.add(guest2);
        hotel1.checkInGuestsToBedroom(1, guests);
        assertEquals(2, bedroom1.getGuestCount());
    }

    @Test
    public void canCheckGuestsOutOfBedroom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        hotel1.checkInGuestsToBedroom(1, guests);
        hotel1.checkOutGuestsFromBedroom(1);
        assertEquals(0, bedroom1.getGuestCount());
    }

    @Test
    public void canCheckGuestsIntoConferenceRoom() {
        conferenceRoom1.checkInGuestIndividual(guest1);
        assertEquals(1, conferenceRoom1.getGuestCount());

    }

    @Test
    public void cantCheckGuestsIntoConferenceRoom() {
        conferenceRoom1.checkInGuestIndividual(guest1);
        conferenceRoom1.checkInGuestIndividual(guest2);
        assertEquals(2, conferenceRoom1.getGuestCount());
    }

    @Test
    public void canCheckGuestsOutOfConferenceRoom() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        hotel1.checkInGuestsToConferenceRoom("Conference Room 1", guests);
        hotel1.checkOutGuestsFromConferenceRoom("Conference Room 1");
        assertEquals(0, conferenceRoom1.getGuestCount());
    }

    @Test
    public void canCreateBooking() {
        Booking booking = hotel1.createBooking(bedroom1, 2);
        assertEquals(100.00, booking.getTotalBill(), 0.01);
    }

    @Test
    public void canFindVacantBedrooms() {
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        hotel1.addBedroom(bedroom1);
        hotel1.addBedroom(bedroom2);
        hotel1.checkInGuestsToBedroom(1, guests);
        ArrayList<Bedroom> vacantRooms = hotel1.findVacantBedrooms();
        assert(vacantRooms.contains(bedroom2));
    }

    @Test
    public void canFindADiningRoom() {
        HashMap<String, DiningRoom> testDiningRoom = new HashMap<>();
        testDiningRoom.put("First", diningRoom1);
        assert(testDiningRoom.containsKey("First"));
    }

    @Test
    public void cantFindADiningRoom() {
        DiningRoom nonExistentDiningRoom = hotel1.findDiningRoom("McDonalds");
        assertNull(nonExistentDiningRoom);
    }

    @Test
    public void canCheckGuestsIntoDiningRoom() {
        diningRoom1.checkInGuest(guest1);
        HashMap<String, DiningRoom> testDiningRoom = new HashMap<>();
        testDiningRoom.put("First", diningRoom1);
        hotel1.setDiningRooms(testDiningRoom);
        assertEquals(1, diningRoom1.getGuestCount());
    }

    @Test
    public void canCheckGuestsOutOfDiningRoom() {
        diningRoom1.checkInGuest(guest1);
        diningRoom1.checkInGuest(guest2);
        diningRoom1.checkInGuest(guest3);
        HashMap<String, DiningRoom> testDiningRoom = new HashMap<>();
        testDiningRoom.put("First", diningRoom1);
        hotel1.setDiningRooms(testDiningRoom);
        hotel1.checkOutGuestsFromDiningRoom("First");
        assertEquals(0, diningRoom1.getGuestCount());
    }

}
