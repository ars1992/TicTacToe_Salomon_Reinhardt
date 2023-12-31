package spielfeld;

import java.util.Arrays;

public class Spielfeld {

    private char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };
    private int anzahlZuege = 0;

    public char[][] getBoard(){
        return this.board;
    }

    public void setAnzahlZuege(int i){
        this.anzahlZuege = i;
    }

    public void setBoard(int index, char symbol){
        if ("123456789".indexOf((char) (index + 48)) >= 0) {
            if (index <= 3) {
                this.board[0][(index - 1) % 3] = symbol;
            } else if (index <= 6) {
                this.board[1][(index - 1) % 3] = symbol;
            } else {
                this.board[2][(index - 1) % 3] = symbol;
            }
        }
    }

    /**
     * Prüft, ob das Spiel unentschieden ausgegangen ist.
     * @return boolean
     */
    public boolean istUnentschieden(){
        return this.anzahlZuege == 9 && ! istGewonnen();
    }

    /**
     * Prüft, ob das Spiel gewonnen wurde
     * horizontal, vertikal und diagonal
     * @return boolean
     */
    public boolean istGewonnen(){
        if (istGewonnenHorizontal()) return true;
        if (istGewonnenVertikal()) return true;
        if (istGewonnenDiagonal('X')) return true;
        return istGewonnenDiagonal('O');
    }

    /**
     * Überprüft, ob das spiel diagonal gewonnen wurde
     * @return boolean
     */
    private boolean istGewonnenDiagonal(char symbol) {
        char[] diagonale1 = {board[0][0], board[1][1], board[2][2]};
        char[] diagonale2 = {board[0][2], board[1][1], board[2][0]};
        return Arrays.equals(diagonale1, new char[]{symbol, symbol, symbol}) || Arrays.equals(diagonale2, new char[]{symbol, symbol, symbol});
    }

    /**
     * Überprüft, ob das spiel vertikal gewonnen wurde
     * @return boolean
     */
    private boolean istGewonnenVertikal() {
        int zaehlerX = 0;
        int zaehlerO = 0;
        for (int i = 0; i < this.board.length; i++){
            for (int j = 0; j < this.board[i].length; j++){
                if (this.board[j][i] == 'X'){
                    zaehlerX++;
                }
                if (this.board[j][i] == 'O'){
                    zaehlerO++;
                }
            }
            if (zaehlerX == 3 || zaehlerO == 3){
                return true;
            } else {
                zaehlerO = 0;
                zaehlerX = 0;
            }
        }
        return false;
    }

    /**
     * Überprüft, ob das Spiel horizontal gewonnen wurde
     * @return boolean
     */
    private boolean istGewonnenHorizontal(){
        int zaehlerX = 0;
        int zaehlerO = 0;
        for (int i = 0; i < this.board.length; i++){
            for (int j = 0; j < this.board[i].length; j++){
                if (this.board[i][j] == 'X'){
                    zaehlerX++;
                }
                if (this.board[i][j] == 'O'){
                    zaehlerO++;
                }
            }
            if (zaehlerX == 3 || zaehlerO == 3){
                return true;
            } else {
                zaehlerO = 0;
                zaehlerX = 0;
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder spielfeld = new StringBuilder();
        for (int i = 0; i < this.board.length; i++){
            if ( i >= 1)
                spielfeld.append("-+-+-\n");
            spielfeld.append(this.board[i][0]).append("|").append(this.board[i][1]).append("|").append(this.board[i][2]).append("\n");
        }
        return spielfeld.toString();
    }

    /**
     * Setzt, das board wieder auf den Anfangszustand
     */
    public void resetBoard(){
        this.board = new char[][]{
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
    }
}
