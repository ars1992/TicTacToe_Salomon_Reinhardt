import spielfeld.Spielfeld;

public class Main {
    public static void main(String[] args) {
        Spielfeld s = new Spielfeld();
        System.out.println(s);
        char[] symbol = {'X', 'O'};
        int spieler = 0;
        for(int i = 0; i < 9; i++){
            s.setBoard(i + 1, symbol[spieler]);
            if (s.istGewonnen()){
                System.out.println(symbol[spieler]);
            }
            spieler = 1 - spieler;
        }


        System.out.println(s);
        System.out.println(s.istGewonnen());
    }
}