import processing.core.PApplet;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.util.Base64;
public class DatabaseProject extends PApplet {
Button but = new Button(this,100,100,200,200);
InputField username = new InputField(this,400,400,200,50,"Username");
    InputField password = new InputField(this,400,600,200,50,"Password");
    boolean usernameCheck, passwordCheck;
    String inputStringU,inputStringP;
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
     //   but.draw();
        username.display();
        password.display();
    }

    @Override
    public void mousePressed() {
      //  System.out.println(but.registerClick(mousePressed));
        usernameCheck=false;
        passwordCheck=false;
        usernameCheck=username.mouseCollision(mouseX,mouseY);
        passwordCheck=password.mouseCollision(mouseX,mouseY);
    }

    @Override
    public void keyTyped() {
    if(usernameCheck==true)
            inputStringU=username.input(true,key);
        if(passwordCheck==true)
            inputStringP=password.input(true,key);
    }

    @Override
    public void keyReleased() {
        if(usernameCheck==true)
            inputStringU=username.input(false,key);
        if(passwordCheck==true)
            inputStringP=password.input(false,key);
    }
}
