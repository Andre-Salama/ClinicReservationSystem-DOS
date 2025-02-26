package Clinic;

public class Reservation {
    
    private static int id = 1; // Used for auto-generated IDs
    private final int RID; //Reservation ID
    private final int PID; //Patient ID
    private Slot slot;
    
    public Reservation(int PID, Slot slot) { //Reserve slot
        this.slot = slot;
        this.PID = PID;
        RID = id++;
        slot.setAvailability(false);
        slot.getAssignedTo().increaseRevenue();
        slot.setReservation(this);
    }

    /*------------------------------------
    toString
    &
    equals
    ---------------------------------------*/
    @Override
    public String toString() {
        return "\nRID: " + RID + "\n Date: " + slot.getDay()
                + "\n Room: " + slot.getRoom() + "\n Time: " + slot.getTime() + "\nPID: " + PID;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Reservation) {
            if (this == o)
                return true;
            else {
                if (this.RID == ((Reservation) o).RID)
                    return true;
                else
                    return false;
            }
        }
        else
            return false;
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public int getRID() {
        return RID;
    }
    
    public Slot getSlot() {
        return slot;
    }
    
    public void setSlot(Slot slot) {
        this.slot.setAvailability(true);
        this.slot = slot;
        slot.getAssignedTo().increaseRevenue();
    }
    
    public int getPID() {
        return PID;
    }
}
