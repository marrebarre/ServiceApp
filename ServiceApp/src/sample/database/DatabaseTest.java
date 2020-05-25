package sample.database;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database = new Database();

    private String expectedStringResult;
    private String actualStringResult;

    @Test
    public void getusername() throws Exception {
        expectedStringResult = "Robert";
        actualStringResult = database.getusername("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getuserstreetaddress() throws Exception {
        expectedStringResult = "Vanna";
        actualStringResult = database.getuserstreetaddress("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getuserphone() throws Exception {
        expectedStringResult = "000";
        actualStringResult = database.getuserphone("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getusercity() throws Exception {
        expectedStringResult = "Malmö";
        actualStringResult = database.getusercity("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getuseraftername() throws Exception {
        expectedStringResult = "Yowakim";
        actualStringResult = database.getuseraftername("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getuserSSN() throws Exception {
        expectedStringResult = "2323";
        actualStringResult = database.getuserSSN("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getEmail() throws Exception {
        expectedStringResult = "Roberty";
        actualStringResult = database.getEmail("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getCV() throws Exception {
        expectedStringResult = "hejhej";
        actualStringResult = database.getCV("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

    @Test
    public void getPassword() throws Exception {
        expectedStringResult = "123";
        actualStringResult = database.getPassword("Roberty");
        Assert.assertEquals(expectedStringResult,actualStringResult);
    }

}