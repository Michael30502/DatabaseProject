import processing.core.PApplet;

public class Button {
    PApplet p;
    int posX,posY;
    int width,height;
    Button(PApplet p,int posX, int posY, int width, int height){
        this.p=p;
        this.posX=posX;
        this.posY=posY;
        this.width=width;
        this.height=height;
    }

    void draw() {
        p.fill(255);
    p.rect(posX,posY,width,height);

    }
    Boolean registerClick(boolean mPressed){

        boolean d;
    if(mPressed && p.mouseX>posX && p.mouseX<posX+width && p.mouseY>posY && p.mouseY<posY+height) {
        d=true;
    }else{
        d=false;
    }
        return d;
    }

}
