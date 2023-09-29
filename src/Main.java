import ui.UIBeenden;
import ui.UIInterface;
import ui.UISpiel;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<UIInterface> menues = new ArrayList<>();


    private static void setMenuPunkte(){
        menues.add(new UISpiel());
        menues.add(new UIBeenden());
    }
    public static void main(String[] args) {
        setMenuPunkte();
        while (true){
            System.out.println("Menu:");
            for (int i = 0; i < menues.size(); i++){
                int menuPunkt = i + 1;
                UIInterface menu = menues.get(i);
                System.out.println(menuPunkt + ": " + menu.getMenuName());
            }
            int eingabe = menuAuswahlTreffen();
            int geweahltesMenu = eingabe - 1;
            System.out.println("Ihre Auswahl: " + eingabe);
            System.out.println(menues.get(geweahltesMenu).getMenuName());
            menues.get(geweahltesMenu).zeigeDialog();

            if (menues.get(geweahltesMenu).getMenuName().equals("Spiel")){
                neuesSpiel(geweahltesMenu);
            }
            if(menues.get(geweahltesMenu).istBeendet()){
                break;
            }
        }
    }
    private static void neuesSpiel(int geweahltesMenu){
        UISpiel spiel = (UISpiel) menues.get(geweahltesMenu);
        while (true){
            spiel.getSpiel().spielen();
            System.out.print("Möchten Sie weiter spielen (j/n): ");
            if ( ! scanner.next().equalsIgnoreCase("j")){
                return;
            }
        }
    }

    private static int menuAuswahlTreffen(){
        int eingabe;
        while (true){
            System.out.print("Auswahl: ");
            try{
                eingabe = scanner.nextInt();
                if(eingabe < 1 || eingabe > menues.size()){
                    System.out.println("Eingabe nicht möglich");
                } else {
                    return eingabe;
                }
            } catch (InputMismatchException ex){
                scanner.next();
                System.out.println("Bitte nur Zahlen eingeben");
            }
        }
    }
}

