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
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT [Username] FROM [Users]");
            ResultSet rp = s.executeQuery("SELECT [Password] FROM [Users]");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                rp.next();

                System.out.println(rp.getString(1));
                System.out.println("");

            }

        }catch (Exception ex){
            System.out.println(ex);
        }


    }






}
