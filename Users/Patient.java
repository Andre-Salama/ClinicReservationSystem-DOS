package Users;

import Clinic.Reservation;
import Clinic.Slot;
import java.util.ArrayList;

public class Patient extends User {

    private static int id = 1; //Auto-generates the IDs
    private final int ID;
    private final ArrayList<Reservation> reservations;

    public Patient(String email, String password, String name, String DOB, String gender) {
        super(email, password, name, DOB, gender);
        reservations = new ArrayList<>();
        ID = id++;
    }

    public static int Login(ArrayList<Patient> AllPatients, String email, String password) {
        if (AllPatients.isEmpty())
            return -1;
        else {
            for (int x = 0; x < AllPatients.size(); x++) {
                if (AllPatients.get(x).getEmail().equals(email))
                    if (AllPatients.get(x).getPassword().equals(password))
                        return x; //It's used to get the correct object for the LOGIN
            }
            return -1; //Indicates "Invalid login"
        }
    }

    public static boolean isTaken(ArrayList<Patient> AllPatients, String email) {
        for (int x = 0; x < AllPatients.size(); x++)
            if (email.equals(AllPatients.get(x).getEmail()))
                return true;
        return false;
    }

    public static void viewAvailableApp(ArrayList<Doctor> AllDoctors, String specialization) {
        ArrayList<Doctor> temp = new ArrayList<>();
        for (int x = 0; x < AllDoctors.size(); x++)
            if (AllDoctors.get(x).getSpecialization().equals(specialization))
                temp.add(AllDoctors.get(x));
        for (int x = 0; x < temp.size(); x++) {
            boolean noAppointment = true;
            System.out.println("\nThe available slots of Dr. " + temp.get(x).getName() + ", fees = " + temp.get(x).getFees() + ": ");
            for (int y = 0; y < temp.get(x).getAssignedSlots().length; y++) {
                if (temp.get(x).getAssignedSlots()[y] == null)
                    continue;
                if (temp.get(x).getAssignedSlots()[y].getAvailability() == true) {
                    System.out.println("Slot ID " + temp.get(x).getAssignedSlots()[y].getSID() + ": " + temp.get(x).getAssignedSlots()[y] + "\n");
                    noAppointment = false;
                }
            }
            if (noAppointment)
                System.out.print("This doctor has no appointments yet.\n");
        }
    }

    public void bookApp(Slot slot) {
        reservations.add(new Reservation(ID, slot));
    }

    public void updateBooking(int A2U, Slot slot) { //A2D: Appointment to update
        reservations.get(A2U - 1).getSlot().getAssignedTo().decreaseRevenue();
        reservations.get(A2U - 1).setSlot(slot);
    }

    public void cancelBooking(int A2D) {
        reservations.get(A2D - 1).getSlot().getAssignedTo().decreaseRevenue();
        reservations.get(A2D - 1).getSlot().setAvailability(true);
        reservations.get(A2D - 1).getSlot().setReservation(null);
        reservations.remove(A2D - 1);
        System.out.println("\nAppointment number " + A2D + " has been cancelled successfully!");
    }

    public void viewBookedApps() {
        if (reservations.isEmpty())
            System.out.println("\nYou have not booked any appointments!");
        else {
            System.out.println("\nThese are your reservations: ");
            for (int x = 0; x < reservations.size(); x++) {
                System.out.println("Reservation number " + ((int) x + 1) + ":" + reservations.get(x) + "\n");
            }
        }
    }

    /*------------------------------------
    toString
    &
    equals
    ---------------------------------------*/
//    @Override
//    public String toString() {
//        retrn "Patient{\nID: " + ID + "\nReservations: " + +reservations.size() + " reservations}";
//    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

}
