package Clinic;

import java.util.ArrayList;
import java.util.Scanner;

public class Supply {

    private String name;
    private int quantity;

    public Supply(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static void orderMedicalSupp(ArrayList<Supply> AllRequestedSupplies, Scanner input) { //Order Medical Supplies
        String med_name;
        int count;
        System.out.print("name:-");
        med_name = input.nextLine();
        System.out.print("no of unit:-");
        count = input.nextInt();
        AllRequestedSupplies.add(new Supply(med_name, count));
    }

    public static void viewRequestedSupplies(ArrayList<Supply> AllRequestedSupplies) {
        if (AllRequestedSupplies.isEmpty()) {
            System.out.println("\nNo supplies have been ordered.");
            return;
        }
        for (int x = 0; x < AllRequestedSupplies.size(); x++) {
            System.out.println(AllRequestedSupplies.get(x).getQuantity() + "x "
                    + AllRequestedSupplies.get(x).getName());
        }
    }

    /*------------------------------------
    toString
    &
    equals
    ---------------------------------------*/
    @Override
    public String toString() {
        return "Supply{\nName: " + name + "\nQuantity: " + quantity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this.name == ((Supply) o).name)
            if (this.quantity == ((Supply) o).quantity)
                return true;
        return false;
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
