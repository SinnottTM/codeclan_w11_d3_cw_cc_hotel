import java.util.ArrayList;

public class Booking {

    private Bedroom bedroom;
    private int nightsBooked;

    public Booking(Bedroom bedroom, int nightsBooked){
        this.bedroom = bedroom;
        this.nightsBooked = nightsBooked;
    }

    public Bedroom getBedroom(){
        return this.bedroom;
    }

    public void setBedroom(Bedroom newBedroom){
        this.bedroom = newBedroom;
    }

    public int getNightsBooked(){
        return this.nightsBooked;
    }

    public void setNightsBooked(int newNightsBooked){
        this.nightsBooked = newNightsBooked;
    }

    public double getTotalBill(){
        return this.nightsBooked * this.bedroom.getNightlyRate();
    }

}
