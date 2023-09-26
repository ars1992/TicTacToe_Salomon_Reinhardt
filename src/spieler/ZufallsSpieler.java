package spieler;
import spielfeld.Spielfeld;
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
        zufallszahl = rand.nextInt(9)+1;
        try {
            while(true) {
                if (Validiere.validiereIndex(zufallszahl) && Validiere.validiereObFeldFreiIst(zufallszahl, spielfeld.returnSpielfeld().getBoard())) return zufallszahl;
            }
        }catch(Exception e){
            System.out.println("Es wurde ein Fehler beim Zug von ZufallsSpieler " + e.getMessage());
        }
        return -1;
    }
}
