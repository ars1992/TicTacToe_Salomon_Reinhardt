package spiel;

import spieler.Spieler;
import spielfeld.Spielfeld;

public class Spiel {

    private final Spielfeld SPIELFELD = new Spielfeld();
    private final Spieler[] SPIELER = new Spieler[2];


    public void setSpieler(Spieler spieler1, Spieler spieler2) {
        this.SPIELER[0] = spieler1;
        this.SPIELER[0].setSpielfeld(this.SPIELFELD);
        this.SPIELER[1] = spieler2;
        this.SPIELER[1].setSpielfeld(this.SPIELFELD);
    }

    /**
     * Gibt den Spielverlauf für die Spieler vor.
     */
    public void spielen(){
        int akktuellerSpieler = Math.random() < 0.5 ? 0 : 1;
        int anzahlzuege = 0;
        while (true) {
            System.out.println(this.SPIELFELD);
            System.out.println(SPIELER[akktuellerSpieler].getName() + " ist am Zug");
            System.out.println("Mit dem Stein: " + SPIELER[akktuellerSpieler].getSymbol());
            this.SPIELFELD.setBoard(SPIELER[akktuellerSpieler].zugMachen(), SPIELER[akktuellerSpieler].getSymbol());
            this.SPIELFELD.setAnzahlZuege(++anzahlzuege);

            if (this.SPIELFELD.istGewonnen()){
                System.out.println(SPIELFELD);
                System.out.println("Gewonnen hat: " + SPIELER[akktuellerSpieler].getName());
                break;
            }
            if (this.SPIELFELD.istUnentschieden()){
                System.out.println("Unentschieden");
                break;
            }
            akktuellerSpieler = 1 - akktuellerSpieler;
        }
        this.SPIELFELD.resetBoard();
    }
}
