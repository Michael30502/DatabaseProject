import processing.core.PApplet;

public class Background {

    PApplet p;
    boolean inputCheckChat;
    InputField chatfield = new InputField(p,300,820,600,160,"Chat");
    Background(PApplet p){
        this.p=p;

    }

    void draw(){
        p.background(168,255,255);
        p.fill(82,219,255);
        p.rect(0,0,200,1000);
        p.rect(200,800,800,200);
        p.rect(200,0,800,100);
        p.fill(0);
        chatfield.input(inputCheckChat,p.key);
        chatfield.display();


    }
}
