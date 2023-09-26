package validieren;
import spielfeld.Spielfeld;

public class Validiere {
    /**
     * Prüft ob eingegebener int wert im Zahlenbereich liegt.
     * @param index
     * @return boolean
     */
    public static boolean validiereIndex(int index) {
        return index >= 1 && index <= 9;
    }

    /**
     * Prüft, ob das gewählte Feld frei ist.
     * @param index
     * @param spielfeld
     * @return boolean
     */
    public static boolean validiereObFeldFreiIst(int index, Spielfeld spielfeld){
        return "XO".indexOf(spielfeld.getBoard()[(index - 1) / 3][(index - 1) % 3]) < 0;
    }
}
