import spiel.Spiel;
import spieler.AISpieler;
import spieler.MenschSpieler;
import spieler.Spieler;
import spielfeld.Spielfeld;
import ui.UIBeenden;
import ui.UIInterface;
import ui.UISpiel;
import validieren.Validiere;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        debugSandro();
        //debugPascal();

    }

    //danke sandro

    private static void debugPascal(){
        // hier kannst du dein code testen
        // Sandros methode in main einfach auskommentieren

        Spielfeld spielfeld = new Spielfeld();
        //Spieler menschSpieler = new MenschSpieler("Sandro der Große", 'O', spielfeld);
        Spieler menschSpieler2  = new AISpieler("AI", 'X', spielfeld);
        Spieler menschSpieler  = new AISpieler("AI-2", 'O', spielfeld);
        //Spieler menschSpieler2 = new MenschSpieler("Pascal der Kleine", 'X', spielfeld);
        Spieler[] spieler = {menschSpieler, menschSpieler2};
        // teste mal deine methode mit der eingabe h

        int akktuellerSpieler = 0;
        int anzahlzuege = 0;
        while (true) {
            System.out.println(spielfeld);
            System.out.println(spieler[akktuellerSpieler].getName() + " ist am Zug");
            System.out.println("Mit dem Stein: " + spieler[akktuellerSpieler].getSymbol());
            spielfeld.setBoard(spieler[akktuellerSpieler].zugMachen(), spieler[akktuellerSpieler].getSymbol());
            spielfeld.setAnzahlZuege(++anzahlzuege);

            if (spielfeld.istGewonnen()){
                System.out.println("Gewonnen hat:");
                System.out.println(spieler[akktuellerSpieler].getName());
                break;
            }
            if (spielfeld.istUnentschieden()){
                System.out.println("unetschieden");
                break;
            }
            akktuellerSpieler = 1 - akktuellerSpieler;
        }
        System.out.println(spielfeld);

    }

    private static void debugSandro(){
        Scanner scanner = new Scanner(System.in);
        List<UIInterface> menues = new ArrayList<>();
        menues.add(new UISpiel());
        menues.add(new UIBeenden());
        while (true){
            System.out.println("Menu:");
            for (int i = 0; i < menues.size(); i++){
                int menuPunkt = i + 1;
                UIInterface menu = menues.get(i);
                System.out.println(menuPunkt + ": " + menu.getMenuName());
            }
            System.out.print("Auswahl: ");
            int eingabe = scanner.nextInt();
            int geweahltesMenu = --eingabe;
            System.out.println("Ihre Auswahl: " + eingabe);
            System.out.println(menues.get(geweahltesMenu).getMenuName());
            menues.get(geweahltesMenu).zeigeDialog();

            if (menues.get(geweahltesMenu).getMenuName().equals("Spiel")){
                UISpiel spiel = (UISpiel) menues.get(geweahltesMenu);
                spiel.getSpiel().spielen();
            }

            if(menues.get(geweahltesMenu).istBeendet()){
                break;
            }
        }


    }




}

