import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(String name) {
        this.name = name;
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRooms = new HashMap<>();

    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public ArrayList<Bedroom> getBedrooms() {
        return this.bedrooms;
    }

    public void setBedrooms(ArrayList<Bedroom> newBedrooms) {
        this.bedrooms = newBedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return this.conferenceRooms;
    }

    public void setConferenceRooms(ArrayList<ConferenceRoom> newConferenceRoom) {
        this.conferenceRooms = newConferenceRoom;
    }

    public HashMap<String, DiningRoom> getDiningRooms() {
        return this.diningRooms;
    }

    public void setDiningRooms(HashMap<String, DiningRoom> newDiningRoom) {
        this.diningRooms = newDiningRoom;
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void removeBedroom(Bedroom bedroom) {
        this.bedrooms.remove(bedroom);
    }

    public void addConference(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.add(conferenceRoom);
    }

    public void removeConference(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.remove(conferenceRoom);
    }

//    public void addDiningRoom(HashMap<String, DiningRoom> newDiningRoom) {
//        this.diningRooms.put(newDiningRoom);
//    }

    public void removeDiningRoom(DiningRoom diningRoom) {
        this.diningRooms.remove(diningRoom);
    }

    public void checkInGuestBedroom(Guest guest, Bedroom bedroom) {
        bedroom.checkInGuestIndividual(guest);
    }

    public void checkOutGuestBedroom(Guest guest, Bedroom bedroom) {
        bedroom.checkOutGuestIndividual(guest);
    }

    public void checkInGuestConference(Guest guest, ConferenceRoom conferenceRoom) {
        conferenceRoom.checkInGuestIndividual(guest);
    }

    public void checkOutGuestConference(Guest guest, ConferenceRoom conferenceRoom) {
        conferenceRoom.checkOutGuestIndividual(guest);
    }

    public Booking bookRoom(Bedroom bedroomToBook, int nightsBooked) {
        Booking booking = new Booking(bedroomToBook, nightsBooked);
        return booking;
    }

    public Bedroom findBedroom(int roomNumber) {
        Bedroom foundRoom = null;
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.getNumber() == roomNumber) {
                foundRoom = bedroom;
            }
        }
        return foundRoom;
    }

    public ConferenceRoom findConferenceRoom(String roomName) {
        ConferenceRoom foundRoom = null;
        for (ConferenceRoom conferenceRoom : this.conferenceRooms) {
            if (conferenceRoom.getName() == roomName) {
                foundRoom = conferenceRoom;
            }
        }
        return foundRoom;
    }

    public DiningRoom findDiningRoom(String roomName) {
        return diningRooms.get(roomName);
    }

    public void checkInGuestsToBedroom(int roomNumber, ArrayList<Guest> guests) {
        Bedroom bedroom = findBedroom(roomNumber);
        if (bedroom != null && bedroom.isVacant()) {
            for (Guest guest : guests) {
                bedroom.checkInGuestIndividual(guest);
            }
        }
    }

    public void checkOutGuestsFromBedroom(int roomNumber) {
        Bedroom bedroom = findBedroom(roomNumber);
        if (bedroom != null) {
            bedroom.checkOutGuestsAll();
        }
    }

    public void checkInGuestsToDiningRoom(String roomName, ArrayList<Guest> guests) {
        DiningRoom diningRoom = findDiningRoom(roomName);
        if (diningRoom != null) {
            for (Guest guest : guests) {
                diningRoom.checkInGuest(guest);
            }
        }
    }

    public void checkOutGuestsFromDiningRoom(String roomName) {
        DiningRoom diningRoom = findDiningRoom(roomName);
        if (diningRoom != null) {
            diningRoom.checkOutGuests();
        }
    }

    public void checkInGuestsToConferenceRoom(String roomName, ArrayList<Guest> guests) {
        ConferenceRoom conferenceRoom = findConferenceRoom(roomName);
        if (conferenceRoom != null) {
            for (Guest guest : guests) {
                conferenceRoom.checkInGuestIndividual(guest);
            }
        }
    }

    public void checkOutGuestsFromConferenceRoom(String roomName) {
        ConferenceRoom conferenceRoom = findConferenceRoom(roomName);
        if (conferenceRoom != null) {
            conferenceRoom.checkOutGuests();
        }
    }

    public Booking createBooking(Bedroom bedroom, int numOfNights) {
        Booking booking = new Booking(bedroom, numOfNights);
        return booking;
    }

    public ArrayList<Bedroom> findVacantBedrooms() {
        ArrayList<Bedroom> vacantRooms = new ArrayList<Bedroom>();
        for (Bedroom bedroom : this.bedrooms) {
            if (bedroom.isVacant()) {
                vacantRooms.add(bedroom);
            }
        }
        return vacantRooms;
    }
}
