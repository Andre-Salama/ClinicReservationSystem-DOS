package main;

import Users.*;
import Clinic.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Admin> AllAdmins = new ArrayList<>();
    static ArrayList<Doctor> AllDoctors = new ArrayList<>();
    static ArrayList<Patient> AllPatients = new ArrayList<>();
    static ArrayList<Supply> AllRequestedSupplies = new ArrayList<>();
    static Slot[] AllSlots = new Slot[273];

    public static void main(String[] args) {
//------------------------------------------------------------------------------
        Slot.initializeAllSlots(AllSlots);
        AllDoctors.add(new Doctor("dermatology", 40, 12345, "Mohammed12345@yahoo.com", "12345", "Mohammed", "1/1/1987", "Male", 350));
        AllDoctors.add(new Doctor("dermatology", 35, 54321, "Ali54321@gmail.com", "54321", "Ali", "5/7/1970", "Male", 300));
        AllDoctors.add(new Doctor("dermatology", 45, 56789, "Sara56789@gmail.com", "56789", "Sara", "30/2/1989", "Female", 400));
        AllDoctors.add(new Doctor("oncology", 30, 216895, "Andre216895@gmail.com", "216895", "Andre", "9/12/1977", "Male", 500));
        AllDoctors.add(new Doctor("oncology", 35, 215217, "Ziad215217@gmail.com", "215217", "Ziad", "2/1/1980", "Male", 450));
        AllDoctors.add(new Doctor("dentist", 45, 193553, "Samah@gmail.com", "193553", "Samah", "12/7/1990", "Female", 500));

        AllAdmins.add(new Admin(192837, "Hassan192837@gmail.com", "192837", "Hassan", "1/1/2001", "Male"));

        AllPatients.add(new Patient("Andre216895@gmail.com", "216895", "Andre", "1/3/1980", "Male")); //For testing
//------------------------------------------------------------------------------
        int choice;
        do {
            System.out.println("------- Clinic --------");
            System.out.println("1 - Doctor.");
            System.out.println("2 - Patient.");
            System.out.println("3 - Admin.");
            System.out.println("4 - Exit.");
            choice = input.nextInt();
            input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
            switch (choice) {

                //---------------------------Doctor case---------------------------
                case 1: {
                    String email;
                    String password;
                    System.out.print("\nPlease enter your email: ");
                    email = input.nextLine();
                    System.out.print("Please enter your password: ");
                    password = input.nextLine();
                    int loggedAs = Doctor.Login(AllDoctors, email, password);
                    if (loggedAs != -1) {
                        Doctor account = AllDoctors.get(loggedAs);
                        System.out.println("\n------- Welecome Dr. " + account.getName()
                                + " -------");
                        int input1;
                        do {
                            System.out.println("\n1 - Browse Schedule.");
                            System.out.println("2 - Update Schedule.");
                            System.out.println("3 - Update Fees.");
                            System.out.println("4 - Order Medical Supplies.");
                            System.out.println("5 - View Revenue.");
                            System.out.println("6 - Logout.");
                            input1 = input.nextInt();
                            input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
                            switch (input1) {
                                case 1:
                                    account.browseSchedule();
                                    break;
                                case 2:
                                    account.browseSchedule();
                                    System.out.print("\nWhich slot do you want to replace? Enter its number: ");
                                    int slotID = input.nextInt();
                                    Slot.viewAvailableApp(AllSlots);
                                    System.out.print("\nWhich slot do you want to take? Enter its ID: ");
                                    int slotID2 = input.nextInt();
                                    account.setSlot(AllSlots[slotID2 - 1], slotID - 1);
                                    System.out.println("\nSchedule updated successfully!");
                                    break;
                                case 3:
                                    System.out.println("\nPlease enter the new fees: ");
                                    double fees = input.nextDouble();
                                    account.setFees(fees);
                                    break;
                                case 4:
                                    Supply.orderMedicalSupp(AllRequestedSupplies, input);
                                    break;
                                case 5:
                                    System.out.println("\nRevenue: " + account.getRevenue());
                                    break;
                                case 6:
                                    System.out.println("\nLogging out..\n");
                                    break;
                                default:
                                    System.out.println("\nPlease enter a valid choice!");
                                    break;
                            }
                        }
                        while (input1 != 6);
                    }
                    else
                        System.out.println("\nInvalid email & password!");
                }
                break;
                //---------------------------Patient case---------------------------
                case 2: {
                    int choice2;
                    do {
                        System.out.println("\n1 - Sign up\n2 - Login\n3 - Back\n");
                        choice2 = input.nextInt();
                        input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
                        switch (choice2) {
                            case 1: {
                                String email, password, name, DOB, gender;
                                System.out.print("\nPlease enter your email: ");
                                email = input.nextLine();
                                while (Patient.isTaken(AllPatients, email)) {
                                    System.out.println("This email is taken, please enter another one!\nCancel: -1");
                                    email = input.nextLine();
                                    if (email.equals("-1"))
                                        break;
                                }
                                if (email.equals("-1"))
                                    break;
                                System.out.print("Please enter your password: ");
                                password = input.nextLine();
                                System.out.print("Please enter your name: ");
                                name = input.nextLine();
                                System.out.print("Please enter your date of birth: ");
                                DOB = input.nextLine();
                                System.out.print("Please enter your gender: ");
                                gender = input.nextLine();
                                AllPatients.add(new Patient(email, password, name, DOB, gender));
                                System.out.println("\nAccount created successfully!");
                            }
                            break;
                            case 2: {
                                String email;
                                String password;
                                System.out.print("\nPlease enter your email: ");
                                email = input.nextLine();
                                System.out.print("Please enter your password: ");
                                password = input.nextLine();
                                int loggedAs = Patient.Login(AllPatients, email, password);
                                if (loggedAs != -1) {
                                    Patient account = AllPatients.get(loggedAs);
                                    System.out.println("\n------- Welcome " + account.getName() + " -------");
                                    int input2;
                                    do {
                                        System.out.println("\n1 - Browse Doctors Avaliable Appointments.");
                                        System.out.println("2 - Update Account.");
                                        System.out.println("3 - Book an Appointment.");
                                        System.out.println("4 - Cancel an Appointment.");
                                        System.out.println("5 - Update an Appointment.");
                                        System.out.println("6 - Browse Booked Appointmens(s).");
                                        System.out.println("7 - Logout.");
                                        input2 = input.nextInt();
                                        input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
                                        switch (input2) {
                                            case 1: {
                                                System.out.println("\nWhat kind of appointments do you want to search for? (Specialization)");
                                                String spec = input.nextLine();
                                                Patient.viewAvailableApp(AllDoctors, spec);
                                            }
                                            break;
                                            case 2:
                                                account.updateAccount();
                                                break;
                                            case 3: {
                                                System.out.println("\nWhat kind of appointment do you want to make? (Specialization)");
                                                String spec = input.nextLine();
                                                Patient.viewAvailableApp(AllDoctors, spec);
                                                System.out.print("\n\nEnter the slot ID of the slot you'd like to reserve: ");
                                                int slotNum = input.nextInt();
                                                account.bookApp(AllSlots[slotNum - 1]);
                                                System.out.println("\nAppointment has been booked successfully!");
                                            }
                                            break;
                                            case 4: {
                                                account.viewBookedApps();
                                                System.out.print("\nEnter the number of the reservation you'd like to cancel: ");
                                                int resNum = input.nextInt();
                                                account.cancelBooking(resNum);
                                            }
                                            break;
                                            case 5: {
                                                account.viewBookedApps();
                                                if (account.getReservations().isEmpty())
                                                    break;
                                                System.out.print("\n\nEnter the number of the reservation you'd like to update: ");
                                                int resNum = input.nextInt();
                                                input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
                                                System.out.println("What kind of appointment do you want to make? (Specialization)");
                                                String spec = input.nextLine();
                                                Patient.viewAvailableApp(AllDoctors, spec);
                                                System.out.print("\nPlease enter the ID of the slot you'd like to reserve: ");
                                                int slotID = input.nextInt();
                                                account.updateBooking(resNum, AllSlots[slotID - 1]);
                                                System.out.println("\nAppointment updated successfully!");
                                            }
                                            break;
                                            case 6:
                                                account.viewBookedApps();
                                                break;
                                            case 7:
                                                System.out.println("\nLogging out..\n");
                                                break;
                                            default:
                                                System.out.println("\nPlease enter a valid choice!");
                                                break;
                                        }
                                    }
                                    while (input2 != 7);
                                    break;
                                }
                                else
                                    System.out.println("\nInvalid email and password!");
                            }
                            break;
                            case 3:
                                System.out.println("");
                                break;
                        }
                    }
                    while (choice2 != 3);
                }
                break;
                //---------------------------Admin case---------------------------
                case 3: {
                    String email;
                    String password;
                    System.out.print("\nPlease enter your email: ");
                    email = input.nextLine();
                    System.out.print("Please enter your password: ");
                    password = input.nextLine();
                    int loggedAs = Admin.Login(AllAdmins, email, password);
                    if (loggedAs != -1) {
                        int input3;
                        do {
                            System.out.println("\n------- Admin -------");
                            System.out.println("\n1 - Add a Doctor.");
                            System.out.println("2 - View Medical Supplies Ordered.");
                            System.out.println("3 - Total Clinic Revenue Report.");
                            System.out.println("4 - Logout");
                            input3 = input.nextInt();
                            input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
                            switch (input3) {
                                case 1: {
                                    String spec, emaill, passwordd, name, DOB, gender;
                                    int AOS;
                                    long SSN;
                                    double fees;
                                    System.out.print("\nPlease enter the doctor's SSN: ");
                                    SSN = input.nextLong();
                                    input.nextLine(); //Used to solve the problem with the INPUTS regarding "\n"
                                    System.out.print("Please enter the doctor's email: ");
                                    emaill = input.nextLine();
                                    while (Doctor.isTaken(AllDoctors, emaill)) {
                                        System.out.println("This email is taken, please enter another one!\nCancel: -1");
                                        emaill = input.nextLine();
                                        if (emaill.equals("-1"))
                                            break;
                                    }
                                    if (emaill.equals("-1"))
                                        break;
                                    System.out.print("Please enter the doctor's password: ");
                                    passwordd = input.nextLine();
                                    System.out.print("Please enter the doctor's name: ");
                                    name = input.nextLine();
                                    System.out.print("Please enter the doctor's date of birth: ");
                                    DOB = input.nextLine();
                                    System.out.print("Please enter the doctor's gender: ");
                                    gender = input.nextLine();
                                    System.out.print("Please enter the doctor's specialization: ");
                                    spec = input.nextLine();
                                    System.out.print("Please enter the doctor's salary: ");
                                    fees = input.nextDouble();
                                    System.out.print("Please enter the doctor's amount of slots: ");
                                    AOS = input.nextInt();
                                    AllDoctors.add(new Doctor(spec, AOS, SSN, emaill, passwordd, name, DOB, gender, fees));
                                }
                                break;
                                case 2:
                                    System.out.println("");
                                    Supply.viewRequestedSupplies(AllRequestedSupplies);
                                    break;
                                case 3:
                                    System.out.println("\nTotal revenue: " + Doctor.getTotalRevenue());
                                    break;
                                case 4:
                                    System.out.println("\nLogging out..\n");
                                    break;
                                default:
                                    System.out.println("\nPlease enter a valid choice!");
                                    break;
                            }
                        }
                        while (input3 != 4);
                    }
                    else
                        System.out.println("\nInvalid email and password!");
                }
                break;
                case 4:
                    System.out.println("\n\t\t\t\t\t\t------- Goodbye -------");
                    break;
                default:
                    System.out.println("\nPlease enter a valid choice!");
                    break;
            }
        }
        while (choice != 4);
    }

}

//An alternative function for requesting/ordering supplies()

/*    public static void requestSupplies() {
        boolean con = true; //continue
        String supply;
        int quantity;
        while (con) {
            System.out.println("What do you want to request?");
            supply = input.nextLine();
            System.out.println("How many do you want?");
            quantity = input.nextInt();
            AllRequestedSupplies.add(new Supply(supply, quantity));
            System.out.println("Do you want to request something else?\nTrue: Yes\nFalse: No");
            con = input.nextBoolean();
        }
    }
 */
