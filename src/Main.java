import ui.UIBeenden;
import ui.UIInterface;
import ui.UISpiel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        debugSandro();
        //debugPascal();

    }

    //danke sandro

    private static void debugPascal() {
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
            int geweahltesMenu = eingabe - 1;
            System.out.println("Ihre Auswahl: " + eingabe);
            System.out.println(menues.get(geweahltesMenu).getMenuName());
            menues.get(geweahltesMenu).zeigeDialog();

            if (menues.get(geweahltesMenu).getMenuName().equals("Spiel")){
                UISpiel spiel = (UISpiel) menues.get(geweahltesMenu);
                boolean weiterSpielen = true;
                while (weiterSpielen){
                    spiel.getSpiel().spielen();
                    System.out.print("Möchten Sie weiter spielen (j/n): ");
                    if ( ! scanner.next().equalsIgnoreCase("j")){
                        weiterSpielen = false;
                    }
                }
            }
            if(menues.get(geweahltesMenu).istBeendet()){
                break;
            }
        }
    }
}

