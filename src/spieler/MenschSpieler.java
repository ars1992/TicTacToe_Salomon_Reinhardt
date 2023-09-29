package spieler;

import java.util.InputMismatchException;
import java.util.Scanner;
import validieren.Validiere;

public class MenschSpieler extends Spieler{

    public MenschSpieler(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int zugMachen() {
        Scanner sc = new Scanner(System.in);
        String fehlermeldung = "Ungültige eingabe!";
        while (true) {
            try {
                System.out.print("Feld eingeben: ");
                int eingabe = sc.nextInt();
                if ( ! Validiere.validiereIndex(eingabe)){
                    System.out.println(fehlermeldung + " Bitte Zahlen von 1 - 9");
                    continue;
                }
                if ( ! Validiere.validiereObFeldFreiIst(eingabe, this.getSpielfeld())){
                    System.out.println(fehlermeldung + " Feld ist belegt");
                    continue;
                }
                return eingabe;
            } catch (InputMismatchException ex) {
                sc.next();
                System.out.println(fehlermeldung + " Bitte nur zahlen eingeben");
            }
        }
    }
}
