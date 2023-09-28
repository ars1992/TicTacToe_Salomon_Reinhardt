package spieler;
import validieren.Validiere;
import java.util.Random;

public class ZufallsSpieler extends Spieler{

    private final String[] PHRASEN = {
            "Hebt Geld ab und riecht dran",
            "Werdet einfach Trader",
            "Ihr seid der Phönix",
            "Kommt nach Dubai",
            "90% von euch werden kein Entwickler"
    };

    public ZufallsSpieler(char symbol){
        super(symbol);
        this.setName("Yuri - '" + this.PHRASEN[(int) (Math.random() * this.PHRASEN.length)] + "'");
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
