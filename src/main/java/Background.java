import processing.core.PApplet;

public class Background {

    PApplet p;
    boolean inputCheckChat;
    Background(PApplet p){
        this.p=p;

    }

    void draw(boolean login){

        if(login==true){
            p.background(168,255,255);

        }

        if(login==false){
        p.background(168,255,255);
        p.fill(82,219,255);
        p.rect(0,0,200,1000);
        p.rect(200,800,800,200);
        p.rect(200,0,800,100);
        p.fill(0);
        }



    }
}
