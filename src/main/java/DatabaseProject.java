import processing.core.PApplet;
import java.sql.*;
import javax.crypto.*;
import java.security.*;
import java.util.ArrayList;
import java.util.Base64;
public class DatabaseProject extends PApplet {





    public static void main(String[] args ) {
        PApplet.main("DatabaseProject");
        try {





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


    SQL sql = new SQL();

    InputField chatfield = new InputField(this,300,820,600,160,"Chat");
    Background background = new Background(this);
    boolean usernameCheck, passwordCheck, chatCheck;
    String inputStringU,inputStringP,inputStringC;
    Button loginbutton = new Button(this,400,700,80,30);
    Button registerbutton = new Button(this,520,700,80,30);
    ArrayList<Users> userList = new ArrayList<>();
    ArrayList<ArrayList<Messege>> messegeListList = new ArrayList<>();
    int count;
    boolean login=false;
    boolean chat=true;


    @Override
    public void settings() {
        super.settings();
        size(1000,1000);
        chatfield.p=this;
    }

    @Override
    public void setup() {
        super.setup();
sql.sqlSetup();
sql.setData("grt","lflpd");
        sql.setData("wvo","gllg");
        sql.setData("erog","tgkmr");
        sql.setData("grnkrlk","krego");
        sql.setData("gkpor","gtme");
        sql.setData("lmrtk","gmklrt");
        sql.setData("grtl","ktrmh");

        for(int i = 0;i<5;i++){
            messegeListList.add(new ArrayList<>());
        userList.add(new Users(this,0,100+150*i,messegeListList.get(i)));
        }
        }


    @Override
    public void draw() {
     //   but.draw();
        background.draw(login,chat);
        if(login==true) {
            username.display();
            password.display();
            loginbutton.draw();
            registerbutton.draw();
            fill(0);
            text("Login",425,720);
            text("Register",535,720);

           /* if(inputStringU=="username"&&inputStringP=="password"){
                login=false;
                chat=true;
            }*/
        }
        //her ser laver den alt der sker i draw ohase af selve chatten
        if(chat==true) {
            chatfield.display();
            for(int i = 0;i<userList.size();i++){
                userList.get(i).display();
                userList.get(i).selected(mouseX,mouseY);
                for(int j = 0;j<userList.size();j++){
                    if(userList.get(i).alredyselected==true&&i!=j)
                        userList.get(j).alredyselected=false;
                }
            }
            for (int i = 0; i < userList.size(); i++) {
                if(userList.get(i).alredyselected) {
                    for (int j = 0; j < messegeListList.get(i).size(); j++)
                        messegeListList.get(i).get(j).draw(j, userList.get(i).count);
                }
            }

        }
    }

    @Override
    public void mousePressed() {
      //  System.out.println(but.registerClick(mousePressed));
        if(login==true) {
            usernameCheck = false;
            passwordCheck = false;
            usernameCheck = username.mouseCollision(mouseX, mouseY);
            passwordCheck = password.mouseCollision(mouseX, mouseY);
            loginbutton.registerClick(mousePressed);
            registerbutton.registerClick(mousePressed);
        }
        if(chat==true) {
            chatCheck = false;
            chatCheck = chatfield.mouseCollision(mouseX, mouseY);
        }

    }

    @Override
    public void keyTyped() {

        if(login==true) {
            if (usernameCheck == true)
                inputStringU = username.input(true, key);
            if (passwordCheck == true)
                inputStringP = password.input(true, key);
        }
        if(chat==true){
        if(chatCheck==true)
            inputStringC=chatfield.input(true,key);
        if(key==ENTER) {
            for(int i = 0; i<userList.size();i++){
                if(userList.get(i).alredyselected) {
                    messegeListList.get(i).add(new Messege(this, inputStringC, 300, 800));
                    chatfield.inputString = "";
                    userList.get(i).count++;
                }
            }
        }
        }
    }


    @Override
    public void keyReleased() {
        if(login==true) {
            if (usernameCheck == true)
                inputStringU = username.input(false, key);
            if (passwordCheck == true)
                inputStringP = password.input(false, key);
        }
        if(chat==true) {
            if (chatCheck == true)
                inputStringC = chatfield.input(false, key);
        }
    }

}
