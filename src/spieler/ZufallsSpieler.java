package spieler;
import validieren.Validiere;
import java.util.Random;

public class ZufallsSpieler extends Spieler{
    int zufallszahl;
    public ZufallsSpieler(String name, char symbol){
        super(name, symbol);
    }

    @Override
    public int zugMachen() {
        Random rand = new Random();
        while(true) {
            int zufallszahl = rand.nextInt(9)+1;
            if (Validiere.validiereIndex(zufallszahl) && Validiere.validiereObFeldFreiIst(zufallszahl, getSpielfeld()))
                return zufallszahl;
        }
    }
}
