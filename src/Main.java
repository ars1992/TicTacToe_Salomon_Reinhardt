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

        Spielfeld spielfeld = new Spielfeld();
        Spieler menschSpieler = new MenschSpieler("Sandro der Große", 'O', spielfeld);
        //Spieler aiSpieler = new AISpieler("AI", 'X', spielfeld);
        Spieler menschSpieler2 = new MenschSpieler("Pascal der Kleine", 'X', spielfeld);
        Spieler[] spieler = {menschSpieler, menschSpieler2};
        // teste mal deine methode mit der eingabe h

        int akktuellerSpieler = 0;
        int anzahlzuege = 0;
        while (true) {
            System.out.println(spielfeld);
            System.out.println(spieler[akktuellerSpieler].getName() + " ist am Zug");
            System.out.println("Mit dem Stein: " + spieler[akktuellerSpieler].getSymbol());
            spielfeld.setBoard(spieler[akktuellerSpieler].zugMachen(), spieler[akktuellerSpieler].getSymbol());
            spielfeld.setAnzahlZuege(++anzahlzuege);

            if (spielfeld.istGewonnen()){
                System.out.println(spieler[akktuellerSpieler].getName());
                break;
            }
            if (spielfeld.istUnentschieden()){
                System.out.println("unetschieden");
                break;
            }
            akktuellerSpieler = 1 - akktuellerSpieler;
        }
        System.out.println(spielfeld);

    }

    private static void debugSandro(){

    }


}

