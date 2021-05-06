import java.util.ArrayList;

public class DiningRoom {

    private String name;
    private ArrayList<Guest> guests;

    public DiningRoom(String name) {
        this.name = name;
        this.guests = new ArrayList<Guest>();
    }

    public String getDiningRoomName() {
        return name;
    }

    public void setDiningRoomName(String newName){
        this.name = newName;
    }

    public ArrayList<Guest> getGuests(){
        return this.guests;
    }

    public void setNewGuestList(ArrayList<Guest> newGuestsList){
        this.guests = newGuestsList;
    }

    public int getGuestCount(){
        return this.guests.size();
    }

    public void checkInGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void checkOutGuests() {
        this.guests.clear();
    }
}