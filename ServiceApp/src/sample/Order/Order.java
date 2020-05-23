package sample.Order;

import sample.database.Database;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
    Database database=new Database();
    public static ArrayList<Integer>employees=new ArrayList<>();
    String user;
    int userid;
    int employee;
    String specification;
    String tittle;
    String address;
    String phone;
    public Order(String user,String specification,String tittle,String address,String phone) throws SQLException {
        this.user=user;
        this.specification=specification;
        this.tittle=tittle;
        this.address=address;
        this.phone=phone;
        this.userid= database.getuserid(user);
        database.getavailableemployees();
        SecureRandom random=new SecureRandom();
        this.employee=employees.get(random.nextInt(employees.size()));
        database.insertorder(userid,employee,tittle,specification,phone,address);
    }

}
