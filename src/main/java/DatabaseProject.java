import processing.core.PApplet;

import java.util.ArrayList;

public class DatabaseProject extends PApplet {





    public static void main(String[] args ) {
        PApplet.main("DatabaseProject");
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
    ArrayList<Message> messageList = new ArrayList<>();
    ArrayList<ArrayList<Message>> messageListList = new ArrayList<>();
    int count;
    boolean login=true;
    boolean check = true;
    String currentUser;


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


        for(int i = 0;i<5;i++){
           // messageListList.add(new ArrayList<>());

        }
        }


    @Override
    public void draw() {

        if(login == true && check == true){
            userList=sql.addUsers(userList,this);
            messageList = sql.addMessages(messageList,this);
            check = false;
        }


     //   but.draw();
        background.draw(login);
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
        if(login==false) {
            chatfield.display();
            for(int i = 0;i<userList.size();i++){
                userList.get(i).display();
                userList.get(i).selected(mouseX,mouseY);
                for(int j = 0;j<userList.size();j++){
                    if(userList.get(i).alreadySelected ==true&&i!=j)
                        userList.get(j).alreadySelected =false;
                }
            }
            for (int i = 0; i < userList.size(); i++) {
                if(userList.get(i).alreadySelected) {
                    for (int j = 0; j < messageList.size(); j++)
                        messageList.get(j).draw(j, userList.get(i).count);
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
            if(loginbutton.registerClick(mousePressed)){
                try{
                    if(sql.checkLogin(inputStringU,inputStringP)==true){
                        currentUser = inputStringU;
                    login = false;
                    }
                }catch (Exception Invalid){

                }
            }

            if (registerbutton.registerClick(mousePressed)){
                try{
                sql.setData(inputStringU,inputStringP);
                login = false;
                    currentUser = inputStringU;
                }catch (Exception Invalid){

                }
            }
        }
        if(login==false) {
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
        if(login==false){
        if(chatCheck==true)
            inputStringC=chatfield.input(true,key);
        if(key==ENTER) {
            for(int i = 0; i<userList.size();i++){
                if(userList.get(i).alreadySelected) {
                    
                    sql.putMessage(chatfield.inputString,this);
                    messageList = sql.addMessages(messageList,this);
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
        if(login==false) {
            if (chatCheck == true)
                inputStringC = chatfield.input(false, key);
        }
    }

}
