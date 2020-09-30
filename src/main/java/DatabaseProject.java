import processing.core.PApplet;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.util.Base64;
public class DatabaseProject extends PApplet {




    public static void main(String[] args ) {
        PApplet.main("DatabaseProject");
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:ucanaccess://src//main//resources//DatabaseUsers.accdb");
            String p = "INSERT INTO Users ([Username],[Password]) VALUES (?,?)";
            PreparedStatement pt = conn.prepareStatement(p);
pt.setString(1,"Mathias");
pt.setString(2,"Lugte");
pt.executeUpdate();
            Statement s = conn.createStatement();
          //  p.executeUpdate("INSERT INTO Users VALUES (Mathias,Lugte)");
           /*
            ResultSet rs = s.executeQuery("SELECT [Username] FROM [Users]");
            ResultSet rp = s.executeQuery("SELECT [Password] FROM [Users]");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                rp.next();

                System.out.println(rp.getString(1));
                System.out.println("");

            }
*/
        }catch (Exception ex){
            System.out.println(ex);
        }


    }
	
Button but = new Button(this,100,100,200,200);
InputField username = new InputField(this,400,400,200,50,"Username");
    InputField password = new InputField(this,400,600,200,50,"Password");
    boolean usernameCheck, passwordCheck;
    String inputStringU,inputStringP;


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
