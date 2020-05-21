package sample.database;

import java.sql.*;

public class Database {
    String url = "jdbc:mysql://127.0.0.1:3306/SE1?autoReconnect=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&user=root&password=root";
    Statement statement;
    Connection c;
    public Database() {
        try {
          c = (Connection) DriverManager.getConnection(url);
            statement = c.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("The connection fails");
        }
    }
    //
    //
    //These selects are used to get specific information about users such as name, aftername, city, or address or just anything
    public String getusername(String email,String password) throws SQLException {
        String toreturn="";
        ResultSet rs = statement.executeQuery("SELECT Name FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");
        while (rs.next()) {
           toreturn=rs.getString(1);
            }
        return toreturn;
    }
    public String getuserstreetaddress(String email,String password) throws SQLException {
        String toreturn="";
        ResultSet rs = statement.executeQuery("SELECT StreetAddress FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");
        while (rs.next()) {
            toreturn=rs.getString(1);
        }
        return toreturn;
    }
    public String getuserphone(String email,String password) throws SQLException {
        String toreturn="";
        ResultSet rs = statement.executeQuery("SELECT Phone FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");
        while (rs.next()) {
            toreturn=rs.getString(1);
        }
        return toreturn;
    }
    public String getusercity(String email,String password) throws SQLException {
        String toreturn="";
        ResultSet rs = statement.executeQuery("SELECT City FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");
        while (rs.next()) {
            toreturn=rs.getString(1);
        }
        return toreturn;
    }
    public String getuseraftername (String email,String password) throws SQLException {
        String toreturn="";
        ResultSet rs = statement.executeQuery("SELECT Aftername FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");
        while (rs.next()) {
            toreturn=rs.getString(1);
        }
        return toreturn;
    }
    public String getuserSSN(String email,String password) throws SQLException {
        String toreturn="";
        ResultSet rs = statement.executeQuery("SELECT SSN FROM Employee WHERE Email ='" + email + "'And Password='" + password + "'");
        while (rs.next()) {
            toreturn=rs.getString(1);
        }
        return toreturn;
    }
    //
    //
    //Down here we have some insert methods
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

    //
    //
    //Down here these methods check the validity of the login for both users and employees
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