package sample.users;

import java.util.ArrayList;

public class User {

    public static ArrayList<User> users = new ArrayList<>();

    String firstName;
    String lastName;
    String password;
    String address;
    String email;
    String socialSecurityNr;
    boolean worker;

    public User(String firstName, String lastName, String password, String address, String email, String socialSecurityNr, boolean worker) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.email = email;
        this.socialSecurityNr = socialSecurityNr;
        this.worker = worker;
    }
}
