package spieler;
import spielfeld.Spielfeld;
import validieren.Validiere;
import java.util.Random;



public class ZufallsSpieler extends Spieler{

    public ZufallsSpieler(String name, char symbol){
        super(name, symbol);
    }

    @Override
    public int zugMachen() {
        Random rand = new Random();
        int zufallszahl = rand.nextInt(9)+1;
        try {
            while(true) {
                if (Validiere.validiereIndex(zufallszahl)) return zufallszahl;
            }
        }catch(Exception e){
            System.out.println("Es wurde ein Fehler beim Zug von ZufallsSpieler " + e.getMessage());
        }
        return -1;
    }
}
