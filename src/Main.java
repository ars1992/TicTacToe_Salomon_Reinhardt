import spieler.MenschSpieler;
import spieler.Spieler;
import spielfeld.Spielfeld;
import validieren.Validiere;

public class Main {
    public static void main(String[] args) {
        //debugSandro();
        debugPascal();
    }

    private static void debugPascal(){
        // hier kannst du dein code testen
        // Sandros methode in main einfach auskommentieren
        Spieler menschSpieler = new MenschSpieler("Sandro der Große", 'X');
        Spielfeld spielfeld = new Spielfeld();
        // teste mal deine methode mit der eingabe h
        System.out.println(spielfeld);
        spielfeld.setBoard(menschSpieler.zugMachen(), menschSpieler.getSymbol());
        System.out.println(spielfeld);

    }
    private static void debugSandro(){
        //debug

        if ("123456789".indexOf((char) (48 + 1)) >= 0){
            System.out.println("hallo " + ((char) (48 + 1)));
        }

        Spielfeld s = new Spielfeld();
        Validiere v = new Validiere();

        System.out.println(s);
        char[] symbol = {'X', 'O'};
        int spieler = 0;
        s.setBoard(1, 'O');
        for(int i = 1; i <= 9; i++){
            if (v.validiereIndex(i) && v.validiereObFeldFreiIst(i, s))
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
    }
}

