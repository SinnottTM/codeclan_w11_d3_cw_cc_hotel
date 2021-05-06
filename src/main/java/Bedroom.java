import java.util.ArrayList;

public class Bedroom {

    private int number;
    private int capacity;
    private ArrayList<Guest> guests;
    private String type;
    private double nightlyRate;

    public Bedroom (int number, int capacity, String type, double nightlyRate) {
        this.number = number;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.type = type;
        this.nightlyRate =  nightlyRate;
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int newNumber){
        this.number = newNumber;
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

    public String getType(){
        return this.type;
    }

    public void setType(String newType){
        this.type = newType;
    }

    public double getNightlyRate(){
        return this.nightlyRate;
    }

    public void setNightlyRate(double newNightlyRate){
        this.nightlyRate = newNightlyRate;
    }

    public void checkInGuestIndividual(Guest guest){
        if(getGuestCount() < this.capacity){
            this.guests.add(guest);}
    }

    public void checkOutGuestIndividual(Guest guest){
        this.guests.remove(guest);
    }

    public int getGuestCount(){
        return this.guests.size();
    }

    public boolean isVacant() {
        return this.guests.size() == 0;
    }

    public void checkInGuestsAll(ArrayList<Guest> guests) {
        if (this.guests.size() < this.capacity) {
            for(Guest guest:guests){
                this.guests.add(guest);
            }
        }
    }

    public void checkOutGuestsAll() {
        if (!this.isVacant()) {
            this.guests.clear();
        }
    }

}
