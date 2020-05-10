package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    String url = "jdbc:mysql://127.0.0.1:3306/SE1?autoReconnect=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&user=root&password=root";
    Statement statement;


    public Database() {
        try {
            Connection c = (Connection) DriverManager.getConnection(url);
            statement = c.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("The connection fails");
        }
    }
    public void insertnewuser(String name,String aftername,String streetaddress,String city,String phone,String SSN,String password,String email) {
        try {

            String sqlUpdate = "Insert INTO Customer(Name,Aftername,StreetAddress,City,Phone,SSN,Password,Email) Values('" +name+ "','" + aftername + "','" + streetaddress + "','"+city+"','"+phone+"','"+SSN+"','"+password+"','"+email+"')";
            try {

                statement.executeUpdate(sqlUpdate);
            } catch (Exception e) {

            }
            System.out.println();
            System.out.println("Table updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertemployee(String name,String aftername,String streetaddress,String city,String phone,String cv,String SSN,String email,String password){
        try {

            String sqlUpdate = "Insert INTO Employee(Name,Aftername,StreetAddress,City,Phone,Cv,SSN,Email,Password) Values('" +name+ "','" + aftername + "','" + streetaddress + "','"+city+"','"+phone+"','"+cv+"','"+SSN+"','"+email+"','"+password+"')";
            try {

                statement.executeUpdate(sqlUpdate);
            } catch (Exception e) {

            }
            System.out.println();
            System.out.println("Table updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
