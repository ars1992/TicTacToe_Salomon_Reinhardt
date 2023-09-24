package validieren;

import spielfeld.Spielfeld;


public class Validiere {

    public boolean validiereIndex(int index) {
        return index >= 1 && index <= 9;
    }

    public boolean validiereObFeldFreiIst(int index, Spielfeld board){
        return "XO".indexOf(board.getBoard()[(index - 1) / 3][(index - 1) % 3]) < 0;
    }
}
