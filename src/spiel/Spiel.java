package spiel;

import spieler.Spieler;
import spielfeld.Spielfeld;

public class Spiel {

    private Spielfeld spielfeld = new Spielfeld();
    private Spieler[] spieler = new Spieler[2];

//    public Spiel() {
//        this.spielfeld = new Spielfeld();
//    }

    public void setSpieler(Spieler spieler1, Spieler spieler2) {
        this.spieler[0] = spieler1;
        this.spieler[0].setSpielfeld(this.spielfeld);
        this.spieler[1] = spieler2;
        this.spieler[1].setSpielfeld(this.spielfeld);
    }

    public void spielen(){
        int akktuellerSpieler = Math.random() < 0.5 ? 0 : 1;
        int anzahlzuege = 0;
        while (true) {
            System.out.println(this.spielfeld);
            System.out.println(spieler[akktuellerSpieler].getName() + " ist am Zug");
            System.out.println("Mit dem Stein: " + spieler[akktuellerSpieler].getSymbol());
            this.spielfeld.setBoard(spieler[akktuellerSpieler].zugMachen(), spieler[akktuellerSpieler].getSymbol());
            this.spielfeld.setAnzahlZuege(++anzahlzuege);

            if (this.spielfeld.istGewonnen()){
                System.out.println("Gewonnen hat:");
                System.out.println(spieler[akktuellerSpieler].getName());
                break;
            }
            if (this.spielfeld.istUnentschieden()){
                System.out.println("unetschieden");
                break;
            }
            akktuellerSpieler = 1 - akktuellerSpieler;
        }
        System.out.println(spielfeld);
    }



}
