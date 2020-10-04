import org.hsqldb.rights.User;

import java.sql.*;

public class SQL {


    Connection conn;


    SQL(){


    }

    void sqlSetup(){
        try{
        conn = DriverManager.getConnection("jdbc:ucanaccess://src//main//resources//DatabaseUsers.accdb");
        System.out.println("Connection Worked M8");
        }
        catch(Exception Fork){
            System.out.println("NO CONNECTION: "+ Fork);
        }
        }

    void setData(String username,String password){

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

            pt.setString(1,username);
            pt.setString(2,password);
            pt.execute();
            System.out.println("User: "+ username + " has been inserted with password: "+ password);

        }catch(Exception FORK){
            System.out.println("Setdata:  "+FORK);
        }

    }

    boolean checkLogin(String username,String password){
        try{
            Statement s = conn.createStatement();
            ResultSet passwords = s.executeQuery("SELECT password FROM [User]");
            while (passwords.next()){
                if(passwords.getString(1).equals(password))
                    return true;

            }


        }catch(Exception Rart){
            System.out.println(Rart);
        return false;

        }
return false;
    }


    void getData(String username){


    }

}
