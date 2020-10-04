import processing.core.PApplet;

import java.util.ArrayList;

public class Users {
    PApplet p;
    String username;
    int posX, posY;
    boolean alreadySelected =false;
    int count;
    Users(PApplet p, int posX, int posY, String username){
        this.p=p;
        this.posX = posX;
        this.posY = posY;
        this.username = username;
    }

    void display(){

        p.fill(82,194,255);
        if((selected(p.mouseX,p.mouseY)==true&&p.mousePressed)|| alreadySelected) {
            p.fill(82, 154, 255);
            alreadySelected =true;
        }
        p.rect(posX, posY,200,150);

    }

    boolean selected(int mouseX,int mouseY){
        if(mouseX> posX &&mouseX< posX +200&&mouseY> posY &&mouseY< posY +150){
            return  true;
        }
return false;
    }
}
