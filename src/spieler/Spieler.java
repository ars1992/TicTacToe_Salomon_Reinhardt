package spieler;
import spielfeld.Spielfeld;

public abstract class Spieler {

    private final String name;
    private final char symbol;
    private Spielfeld spielfeld;

    public Spieler(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public Spieler(String name, char symbol, Spielfeld spielfeld){
        this.name = name;
        this.symbol = symbol;
        this.spielfeld = spielfeld;
    }

    public abstract int zugMachen();

    public String getName(){
        return this.name;
    }

    public char getSymbol(){
        return this.symbol;
    }

    public Spielfeld getSpielfeld(){
        return this.spielfeld;
    }
}
