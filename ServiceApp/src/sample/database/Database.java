package sample.database;

import sample.login.Login;

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

    //These selects are used to get specific information about users such as name, aftername, city, or address or just anything
    public String getusername(String email) throws SQLException {
        String toreturn = "";
        ResultSet rs = statement.executeQuery("SELECT Name FROM Employee WHERE email ='" + email + "'");
        while (rs.next()) {
            toreturn = rs.getString(1);
        }
        return toreturn;
    }

    public String getuserstreetaddress(String email) throws SQLException {
        String toreturn = "";
        ResultSet rs = statement.executeQuery("SELECT StreetAddress FROM Employee WHERE email ='" + email + "'");
        while (rs.next()) {
            toreturn = rs.getString(1);
        }
        return toreturn;
    }

    public String getuserphone(String email) throws SQLException {
        String toreturn = "";
        ResultSet rs = statement.executeQuery("SELECT Phone FROM Employee WHERE email ='" + email + "'");
        while (rs.next()) {
            toreturn = rs.getString(1);
        }
        return toreturn;
    }

    public String getusercity(String email) throws SQLException {
        String toreturn = "";
        ResultSet rs = statement.executeQuery("SELECT City FROM Employee WHERE email ='" + email + "'");
        while (rs.next()) {
            toreturn = rs.getString(1);
        }
        return toreturn;
    }

    public String getuseraftername(String email) throws SQLException {
        String toreturn = "";
        ResultSet rs = statement.executeQuery("SELECT Aftername FROM Employee WHERE email ='" + email + "'");
        while (rs.next()) {
            toreturn = rs.getString(1);
        }
        return toreturn;
    }

    public String getuserSSN(String email) throws SQLException {
        String toreturn = "";
        ResultSet rs = statement.executeQuery("SELECT SSN FROM Employee WHERE email ='" + email + "'");
        while (rs.next()) {
            toreturn = rs.getString(1);
        }
        return toreturn;
    }

    //
    //
    public void insertnewuser(String name, String aftername, String streetaddress, String city, String phone, String SSN, String password, String email) {
        try {

            String sqlUpdate = "Insert INTO Customer(Name,Aftername,StreetAddress,City,Phone,SSN,Password,email) Values('" + name + "','" + aftername + "','" + streetaddress + "','" + city + "','" + phone + "','" + SSN + "','" + password + "','" + email + "')";
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

            String sqlUpdate = "Insert INTO Employee(Name,Aftername,StreetAddress,City,Phone,Cv,SSN,email,Password) Values('" + name + "','" + aftername + "','" + streetaddress + "','" + city + "','" + phone + "','" + cv + "','" + SSN + "','" + email + "','" + password + "')";
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

    public void updateEmployee(String name, String aftername, String streetaddress, String city, String phone, String cv, String SSN, String email, String password) {
        try {

            String sqlUpdate = "UPDATE Employee SET" +
                    "Name = '" + name + "'," +
                    "Aftername= '" + aftername + "'," +
                    "StreetAddress= '" + streetaddress + "'," +
                    "City= '" + city + "'," +
                    "Phone= '" + phone + "'," +
                    "Cv= '" + cv + "'," +
                    "SSN= '" + SSN + "'," +
                    "email= '" + email + "'," +
                    "Password= '" + password + "'" +
                    " WHERE Email = '" + Login.email;
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
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee WHERE email ='" + email + "'And Password='" + password + "'");

            while (rs.next()) {
                if (rs.getString(10).equals(email)) {
                    if (rs.getString(11).equals(password)) {
                        exists = true;
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
            ResultSet rs = statement.executeQuery("SELECT * FROM Customer WHERE email ='" + email + "'And Password='" + password + "'");

            while (rs.next()) {
                if (rs.getString(8).equals(email)) {
                    if (rs.getString(9).equals(password)) {
                        exists = true;
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