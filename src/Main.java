import spieler.AISpieler;
import spieler.MenschSpieler;
import spieler.Spieler;
import spielfeld.Spielfeld;
import validieren.Validiere;

public class Main {
    public static void main(String[] args) {
        //debugSandro();
        debugPascal();
    }

    //danke sandro

    private static void debugPascal(){
        // hier kannst du dein code testen
        // Sandros methode in main einfach auskommentieren
        Spieler menschSpieler = new MenschSpieler("Sandro der Große", 'O');
        Spielfeld spielfeld = new Spielfeld();
        Spieler aiSpieler = new AISpieler("AI", 'X', spielfeld);
        Spieler[] spieler = {menschSpieler, aiSpieler};
        // teste mal deine methode mit der eingabe h
        System.out.println(spielfeld);
        int akktuellerSpieler = 0;
        while ( ! spielfeld.istGewonnen() || spielfeld.istUnentschieden()) {
            spielfeld.setBoard(spieler[akktuellerSpieler]);
            System.out.println(spielfeld);
            akktuellerSpieler = 1 - akktuellerSpieler;
        }
        System.out.println(spieler[akktuellerSpieler].getName());

    }

    private static void debugSandro(){

    }


}

