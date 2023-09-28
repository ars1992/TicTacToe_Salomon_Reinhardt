package spieler;
import spielfeld.Spielfeld;

public abstract class Spieler {

    private String name;
    private final char symbol;
    private Spielfeld spielfeld;

    public Spieler(char symbol){
        this.symbol = symbol;
    }

    public Spieler(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }


    public abstract int zugMachen();
    public void setSpielfeld(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char getSymbol(){
        return this.symbol;
    }

    public Spielfeld getSpielfeld(){
        return this.spielfeld;
    }
}
