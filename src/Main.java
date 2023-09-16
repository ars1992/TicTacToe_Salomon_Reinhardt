import spielfeld.Spielfeld;
import validieren.Validiere;

public class Main {
    public static void main(String[] args) {

        //debug

        Spielfeld s = new Spielfeld();
        Validiere v = new Validiere();
        System.out.println(s);
        char[] symbol = {'X', 'O'};
        int spieler = 0;
        for(int i = 1; i <= 9; i++){
            if (v.validiereIndex(i))
                s.setBoard(i, symbol[spieler]);
            if (s.istGewonnen()){
                System.out.println(symbol[spieler]);
                break;
            }
            spieler = 1 - spieler;
        }
        System.out.println(s);
        System.out.println("ist gewonnen: " + s.istGewonnen());
        System.out.println("ist unentschieden: " + s.istUnentschieden());
        System.out.println("_______________________________________________________________________-");

        Spielfeld s2 = new Spielfeld();
        s2.setBoard(1, 'X');
        System.out.println("feld 1 test: " + v.validiereObFeldFreiIst(1, s2));
        s2.setBoard(5, 'O');
        System.out.println("feld 5 test: " + v.validiereObFeldFreiIst(5, s2));
        System.out.println("feld 9 test: " + v.validiereObFeldFreiIst(9, s2));



    }
}