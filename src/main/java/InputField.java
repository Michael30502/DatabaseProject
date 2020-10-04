import processing.core.PApplet;


public class InputField {

    String inputString ="";
    PApplet p;
    int x,y,w,h;
    String type;


    InputField(PApplet p,int x,int y,int w,int h,String type){

        this.p=p;
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.type = type;
    }

    String input(boolean check,char key) {

        if (check) {

            if (key != '\b' && key != p.CODED) {
                if((type.equals("Username")&&inputString.length()<20)||(type.equals("Password")&&inputString.length()<20)||type.equals("Chat")) {
                    inputString += key;

                    inputString = inputString.replaceAll("[^\\p{javaWhitespace}\\p{Alnum}(-)]", "");
                   // inputString = inputString.toUpperCase();

                }
            } else {
                if (inputString.length() >= 1)
                    inputString = inputString.substring(0, inputString.length() - 1);

            }
        }
        return inputString;
    }
    boolean mouseCollision ( int mX, int mY){
//Check om mouseX og mouseY, er på inputfeltet
        if (((mX < x + w ) && ( mX > x)))
            if(((mY < y + h ) && ( mY > y)))
                return true;

        return false;
    }


    void display () {
        p.fill(255);
        p.rect(x,y,w,h);
        p.fill(0);
        //System.out.println(inputString);
        p.text(inputString, x+5, y+h/2+7);
        if(type.equals("Username"))
            p.text("Username",x-100,y+h/2+7);
        if(type.equals("Password"))
            p.text("Password", x - 100, y + h / 2 + 7);


    }

}