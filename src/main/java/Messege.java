import processing.core.PApplet;

public class Messege {
    PApplet p;
    String messege;
    int posx,posy;
    int w,h;
    Messege(PApplet p,String messege,int posx,int posy){
        this.p=p;
        this.messege=messege;
        this.posx=posx;
        this.posy=posy;
    }

    void draw(int i,int count){
        p.fill(255);
        p.rect(posx,posy-(count-i)*60,500,50,5);
        p.fill(0);
        p.text(messege,posx+10,posy+20-(count-i)*60);

    }

}
