package spieler;
import spielfeld.Spielfeld;

public abstract class Spieler {

    private String name;
    private final char SYMBOL;
    private Spielfeld spielfeld;

    public Spieler(char symbol){
        this.SYMBOL = symbol;
    }

    public Spieler(String name, char symbol){
        this.name = name;
        this.SYMBOL = symbol;
    }

    /**
     * Setzt das Symbol auf das Spielfeld
     * @return int zwischen 1 und 9
     */
    public abstract int zugMachen();
    public void setSpielfeld(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
    }
    public Spielfeld getSpielfeld(){
        return this.spielfeld;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char getSymbol(){
        return this.SYMBOL;
    }

}
