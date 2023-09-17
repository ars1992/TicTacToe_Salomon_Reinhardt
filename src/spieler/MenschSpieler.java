
package spieler;

import spielfeld.Spielfeld;

import java.util.Scanner;
import spielfeld.Spielfeld;
import validieren.Validiere;

public class MenschSpieler extends Spieler{


    public MenschSpieler(String name, char symbol){
        super(name, symbol);
    }

    @Override
    public int zugMachen() {
        Validiere val = new Validiere();
        Scanner sc = new Scanner(System.in);
        try{
            while(true){
                System.out.println("Geben Sie die Zahl des Feldes ein, in das Sie setzen wollen!");
                int feld = sc.nextInt();
                if (val.validiereIndex(feld)) return feld;
            }
        }catch (Exception e){
            System.out.println("Es wurde ein Fehler beim Validieren Ihres angegebenen Wertes festgestellt" + e.getMessage());
        }finally {
            sc.close();
        }return 0;
    }



}
