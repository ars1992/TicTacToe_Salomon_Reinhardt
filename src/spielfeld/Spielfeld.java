package spielfeld;

public class Spielfeld {

    private char[][] board = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    private int anzahlZuege = 0;

    public void setBoard(int index){
        return;
    }

    public boolean istUnentschieden(){
        return this.anzahlZuege == 9 && ! istGewonnen();
    }
    public boolean istGewonnen(){
        this.anzahlZuege++;
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
        }
        return zaehlerX == 3 || zaehlerO == 3;
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
        }
        return zaehlerX == 3 || zaehlerO == 3;
    }
    public String toString(){
        // todo evt terminal clear
        StringBuilder spielfeld = new StringBuilder();
        for (int i = 0; i < 3; i++){
            if ( i >= 1)
                spielfeld.append("-+-+-\n");
            spielfeld.append(this.board[i][0]).append("|").append(this.board[i][1]).append("|").append(this.board[i][2]).append("\n");
        }
        return spielfeld.toString();
    }
}
