package validieren;
import spielfeld.Spielfeld;

public class Validiere {

    public static boolean validiereIndex(int index) {
        return index >= 1 && index <= 9;
    }

    public static boolean validiereObFeldFreiIst(int index, Spielfeld board){
        return "XO".indexOf(board.getBoard()[(index - 1) / 3][(index - 1) % 3]) < 0;
    }
}
