package validieren;

import spielfeld.Spielfeld;

public class Validiere {

    public boolean validiereIndex(int index){
        return index >= 0 && index <= 9;
    }

    public boolean validiereObFeldFreiIst(int index, Spielfeld board){
        System.out.println("XO".indexOf(board.getBoard()[0][(index) % 3]) >= 0);
        if (index <= 3 && "XO".indexOf(board.getBoard()[0][(index) % 3]) >= 0) {
            return false;
        } else if (index <= 6 && "XO".indexOf(board.getBoard()[1][(index) % 3]) >= 0) {
            return false;
        } else return index > 6 && "XO".indexOf(board.getBoard()[2][(index) % 3]) >= 0;
    }
}
