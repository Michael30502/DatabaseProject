import org.hsqldb.rights.User;
import processing.core.PApplet;

import java.sql.*;
import java.util.ArrayList;

public class SQL {


    Connection conn;


    SQL() {


    }

    void sqlSetup() {
        try {
            conn = DriverManager.getConnection("jdbc:ucanaccess://src//main//resources//DatabaseUsers.accdb");
            System.out.println("Connection Worked M8");
        } catch (Exception Fork) {
            System.out.println("NO CONNECTION: " + Fork);
        }
    }

    void setData(String username, String password) {

        try {
            Statement s = conn.createStatement();
            String p = "INSERT INTO User ([Username],[Password]) VALUES (?,?)";
            // ResultSet lastID = s.executeQuery("SELECT LAST(Id) FROM [User]");
            PreparedStatement pt = conn.prepareStatement(p);

/*
            lastID.next();
            int var = lastID.getInt(1);
            System.out.println(var++);
          //  pt.setInt(1,var++);
           */

            pt.setString(1, username);
            pt.setString(2, password);
            pt.execute();
            System.out.println("User: " + username + " has been inserted with password: " + password);

        } catch (Exception FORK) {
            System.out.println("Setdata:  " + FORK);
        }

    }


    ArrayList addUsers(ArrayList userList, PApplet p) {
        try {
            int i = 0;
            Statement s = conn.createStatement();
            ResultSet usernames = s.executeQuery("SELECT username FROM [User]");
            while (usernames.next())
                userList.add(new Users(p, 0, 100 + 150 * i, usernames.getString(1)));
        } catch (Exception NejTak) {


        }

        return userList;
    }

    ArrayList addMessages(ArrayList messageListL, PApplet p) {
        ArrayList<Message> messageList = new ArrayList<>();
        try {

            Statement s = conn.createStatement();
            ResultSet beskeder = s.executeQuery("SELECT [Besked] FROM [Besked]");

            while (beskeder.next()) {
                messageList.add(new Message(p, beskeder.getString(1), 800, 300));
            }
        } catch (Exception bad) {
            System.out.println("bad" + bad);

        }
        return messageList;
    }

    boolean checkLogin(String username, String password) {
        try {
            Statement s = conn.createStatement();
            ResultSet passwords = s.executeQuery("SELECT password FROM [User]");
            while (passwords.next()) {
                if (passwords.getString(1).equals(password))
                    return true;

            }


        } catch (Exception rart) {
            System.out.println(rart);
            return false;

        }
        return false;
    }

    void putMessage(String input, PApplet p) {
        try {


        Statement s = conn.createStatement();
        String q = "INSERT INTO Besked (Besked) VALUES (?)";

        PreparedStatement pt = conn.prepareStatement(q);


        pt.setString(1, input);

        pt.execute();
    }catch(Exception exception){

        }
}

    void getData(String username){


    }

}
