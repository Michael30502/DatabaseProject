import processing.core.PApplet;

import java.util.ArrayList;

public class Users {
    PApplet p;
    int posx,posy;
    boolean alredyselected =false;
    int count;
    Users(PApplet p, int posx, int posy, ArrayList<Message> messegeList){
        this.p=p;
        this.posx=posx;
        this.posy=posy;
    }

    void display(){

        p.fill(82,194,255);
        if((selected(p.mouseX,p.mouseY)==true&&p.mousePressed)||alredyselected) {
            p.fill(82, 154, 255);
            alredyselected=true;
        }
        p.rect(posx,posy,200,150);

    }

    boolean selected(int mousex,int mousey){
        if(mousex>posx&&mousex<posx+200&&mousey>posy&&mousey<posy+150){
            return  true;
        }
return false;
    }
}
