package spiel;

import spieler.Spieler;
import spielfeld.Spielfeld;

public class Spiel {

    private Spielfeld spielfeld;
    private Spieler[] spieler = new Spieler[2];

    public Spiel(Spielfeld spielfeld) {
        this.spielfeld = spielfeld;
    }

}
