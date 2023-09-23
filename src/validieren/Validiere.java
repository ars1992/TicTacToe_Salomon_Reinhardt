package validieren;

import spielfeld.Spielfeld;


public class Validiere {

    public boolean validiereIndex(int index) {
        return index >= 1 && index <= 9;
    }

    public boolean validiereObFeldFreiIst(int index, Spielfeld board){
        for (int i = 1; i <= 3; i++){
            if (index <= i * 3 && "XO".indexOf(board.getBoard()[i - 1][(index - 1) % 3]) >= 0) {
                return false;
            }
        }
        return true;
    }
}
