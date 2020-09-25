import processing.core.PApplet;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.util.Base64;
public class DatabaseProject extends PApplet {
Button but = new Button(this,100,100,200,200);
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

    @Override
    public void settings() {
        super.settings();
        size(1000,1000);
    }

    @Override
    public void draw() {
        but.draw();
    }

    @Override
    public void mousePressed() {
      //  System.out.println(but.registerClick(mousePressed));
    }
}
