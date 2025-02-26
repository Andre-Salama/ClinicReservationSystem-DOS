package Users;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class User implements ManageAccount {

    private final String DOB;
    private final String name;
    private String email;
    private String password;
    private String mobile;
    private String address;
    private final String gender;

    public User(String email, String password, String name, String DOB, String gender) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.DOB = DOB;
        this.gender = gender;
    }

    @Override
    public void updateAccount() {
        Scanner input = new Scanner(System.in);
        boolean con = true;
        boolean valid = true;
        int choice;
        while (con) {
            if (valid) {
                System.out.print("\nWhat do you want to edit?\nEmail: 1\nPassword: 2\nMobile: 3\nAddress: 4\nExit: 5\n");
                valid = true;
            }
            choice = input.nextInt();
            input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
            switch (choice) {
                case 1:
                    System.out.print("\nEnter the new e-mail: ");
                    email = input.nextLine();
                    System.out.print("Do you want to edit something else?\nYes: True\nNo: False\n");
                    con = input.nextBoolean();
                    break;
                case 2:
                    System.out.print("\nEnter the new password: ");
                    password = input.nextLine();
                    System.out.print("Do you want to edit something else?\nYes: True\nNo: False\n");
                    con = input.nextBoolean();
                    break;
                case 3:
                    System.out.print("\nEnter the new mobile: ");
                    mobile = input.nextLine();
                    System.out.print("Do you want to edit something else?\nYes: True\nNo: False\n");
                    con = input.nextBoolean();
                    break;
                case 4:
                    System.out.print("\nEnter the new address: ");
                    address = input.nextLine();
                    System.out.print("Do you want to edit something else?\nYes: True\nNo: False\n");
                    con = input.nextBoolean();
                    break;
                case 5:
                    con = false;
                default:
                    System.out.println("Please enter a valid choice");
                    valid = false;
            }
        }
        System.out.println("Exiting..");
    }

    /*------------------------------------
    Setters
    &
    Getters
    ---------------------------------------*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

}
