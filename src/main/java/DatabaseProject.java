import processing.core.PApplet;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.util.Base64;
public class DatabaseProject extends PApplet {

    public static void main(String[] args ) {
        PApplet.main("DatabaseProject");
        String databaseURL = "jdbc:ucanaccess://src//main//resources//DatabaseUsers.accdb";

try{
Connection connection = DriverManager.getConnection(databaseURL);
System.out.println("Bruh");

connection.close();
} catch (Exception e) {
    e.printStackTrace();
}
    }





}
