package spielfeld;

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

    public boolean setBoard(int index, char symbol){
        if ("123456789".indexOf((char) (index + 48)) >= 0) {
            this.anzahlZuege++;
            if (index <= 3) {
                this.board[0][(index - 1) % 3] = symbol;
            } else if (index <= 6) {
                this.board[1][(index - 1) % 3] = symbol;
            } else {
                this.board[2][(index - 1) % 3] = symbol;
            }
            return true;
        }
        return false;
    }

    public boolean istUnentschieden(){
        return this.anzahlZuege == 9 && ! istGewonnen();
    }

    public boolean istGewonnen(){
        if (istGewonnenHorizontal()) return true;
        if (istGewonnenVertikal()) return true;
        if (istGewonnenDiagonal('X')) return true;
        return istGewonnenDiagonal('O');
    }

    private boolean istGewonnenDiagonal(char symbol) {
        int zaehler = 0;
        if (this.board[1][1] == symbol) {
            for (int i = 0; i < 3; i += 2) {
                for (int j = 0; j < 3; j += 2) {
                    if (this.board[i][j] == symbol) {
                        zaehler++;
                    }
                }
            }
        }
        return zaehler == 3;
    }

    private boolean istGewonnenVertikal() {
        int zaehlerX = 0;
        int zaehlerO = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
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

    private boolean istGewonnenHorizontal(){
        int zaehlerX = 0;
        int zaehlerO = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
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
        for (int i = 0; i < 3; i++){
            if ( i >= 1)
                spielfeld.append("-+-+-\n");
            spielfeld.append(this.board[i][0]).append("|").append(this.board[i][1]).append("|").append(this.board[i][2]).append("\n");
        }
        return spielfeld.toString();
    }
}
