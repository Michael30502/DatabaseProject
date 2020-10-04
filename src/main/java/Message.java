import processing.core.PApplet;

public class Message {
    PApplet p;
    String message;
    int posx,posy;
    int w,h;
    Message(PApplet p, String message, int posx, int posy){
        this.p=p;
        this.message =message;
        this.posx=posx;
        this.posy=posy;
    }

    void draw(int i,int count){
        p.fill(255);
        p.rect(posx,posy-(count-i)*60,500,50,5);
        p.fill(0);
        p.text(message,posx+10,posy+20-(count-i)*60);

    }

}
