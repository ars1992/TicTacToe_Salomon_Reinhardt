package spieler;
import spielfeld.Spielfeld;

public abstract class Spieler {

    private String name;
    private char symbol;

    public Spieler(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public abstract int zugMachen();

    public String getName(){
        return this.name;
    }

    public char getSymbol(){
        return this.symbol;
    }
/*
    public void resetSpielfeld(Spielfeld spielfeld){
        char[][] board = spielfeld.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = (char) ('1' + i * 3 + j); // Setzt die Zahlen 1 bis 9 auf das Spielfeld.
            }
        }
        spielfeld.setAnzahlZuege(0); // Methode setAnzahlZüge in main implementieren oder anzahlZüge public machen
    }
    */

}
