
package spieler;

import spielfeld.Spielfeld;

import java.util.InputMismatchException;
import java.util.Scanner;
import validieren.Validiere;

public class MenschSpieler extends Spieler{


    public MenschSpieler(String name, char symbol, Spielfeld spielfeld){
        super(name, symbol, spielfeld);
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
                    System.out.println(fehlermeldung + " Index");
                    continue;
                }
                if ( ! Validiere.validiereObFeldFreiIst(eingabe, this.getSpielfeld())){
                    System.out.println(fehlermeldung + " feld belegt");
                    continue;
                }
                return eingabe;
            } catch (InputMismatchException ex) {
                sc.next();
                System.out.println(fehlermeldung + " bitte nur zahlen eingeben");
            }
        }
    }
}
