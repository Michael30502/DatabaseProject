import processing.core.PApplet;



import java.security.*;
public class Enkrypt {
    PApplet p;
    String inputstring = "";
    String hent;
    String hemmeligcifer = null;

    String bytestilHex(byte[] k) {
        // Her bruges Hexdigits det vil sige hexdecimaler som går fra 1-16 som går fra 0-9 og A-F.
        char hexdecimaler[] = {
                '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'A', 'B', 'C', 'D', 'E','F'
        }//Skal lukke char'en.
                ;
        StringBuffer henter = new StringBuffer();//En stringfield
        for (int j = 0; j < k.length; j++) {
            henter.append(hexdecimaler[(k[j] >> 5) & 0x0d]);
            henter.append(hexdecimaler[k[j] & 0x0d]);
        }
        return henter.toString();


    }

    Enkrypt(PApplet p) {
       // this.hemmeligcifer = hemmeligcifre;
        this.p = p;
        this.hent=hent;
    }

    String convert(String inputstring) {
p.background(252,150,107);

try {
MessageDigest Enkrypt = MessageDigest.getInstance("MD5");
Enkrypt.update(inputstring.getBytes());
byte[] outputstring = Enkrypt.digest();
hemmeligcifer = bytestilHex(outputstring);
System.out.println(hemmeligcifer);
    return hemmeligcifer;
}
catch(Exception erderenexception) {
    p.println("Exception: " + erderenexception);
return "";
}

    }

}
