import java.util.ArrayList;

public class ConferenceRoom {

    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public ConferenceRoom (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }

    public ArrayList<Guest> getGuests(){
        return this.guests;
    }

    public void setGuests(ArrayList<Guest> newGuests){
        this.guests = newGuests;
    }

    public void checkInGuestIndividual(Guest guest){
        if(getGuestCount() < this.capacity){
            this.guests.add(guest);}
    }

    public void checkOutGuestIndividual(Guest guest){
        this.guests.remove(guest);
    }

    public void checkOutGuests() {
        if (this.guests.size() > 0) {
            this.guests.clear();
        }
    }

    public int getGuestCount(){
        return this.guests.size();
    }

}
