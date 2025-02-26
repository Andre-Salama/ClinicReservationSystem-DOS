package Users;

import java.util.ArrayList;

public class Admin extends Staff {

    public Admin(long SSN, String email, String password, String name, String DOB, String gender) {
        super(SSN, email, password, name, DOB, gender);
    }

    public static int Login(ArrayList<Admin> AllAdmins, String email, String password) {
        if (AllAdmins.isEmpty())
            return -1;
        else {
            for (int x = 0; x < AllAdmins.size(); x++) {
                if (AllAdmins.get(x).getEmail().equals(email))
                    if (AllAdmins.get(x).getPassword().equals(password))
                        return x; //It's used to get the correct object for the LOGIN
            }
            return -1; //Indicates "Invalid login"
        }
    }
}
