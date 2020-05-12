package sample.database;

import java.sql.*;

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

    public void insertnewuser(String name, String aftername, String streetaddress, String city, String phone, String SSN, String password, String email) {
        try {

            String sqlUpdate = "Insert INTO Customer(Name,Aftername,StreetAddress,City,Phone,SSN,Password,Email) Values('" + name + "','" + aftername + "','" + streetaddress + "','" + city + "','" + phone + "','" + SSN + "','" + password + "','" + email + "')";
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

    public void insertemployee(String name, String aftername, String streetaddress, String city, String phone, String cv, String SSN, String email, String password) {
        try {

            String sqlUpdate = "Insert INTO Employee(Name,Aftername,StreetAddress,City,Phone,Cv,SSN,Email,Password) Values('" + name + "','" + aftername + "','" + streetaddress + "','" + city + "','" + phone + "','" + cv + "','" + SSN + "','" + email + "','" + password + "')";
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

    public boolean validemployee(String email, String password) {
        boolean exists = false;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");

            while (rs.next()) {
                if (rs.getString(10).equals(email)){
                    if (rs.getString(11).equals(password)){
                        exists=true;
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;

    }

    public boolean validuser(String email, String password) {
        boolean exists = false;
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer WHERE Email ='" + email + "'And Password='" + password + "'");

            while (rs.next()) {
                if (rs.getString(8).equals(email)){
                    if (rs.getString(9).equals(password)){
                        exists=true;
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;

    }
}