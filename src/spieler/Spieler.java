package spieler;
import spielfeld.Spielfeld;

public abstract class Spieler {

    private String name;
    private char symbol;

    public Spieler(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public abstract int zugMachen();  //to-do???

    public String getName(){
        return this.name;
    }

    public char getSymbol(){
        return this.symbol;
    }

    public void resetSpielfeld(Spielfeld spielfeld){

    }

}
