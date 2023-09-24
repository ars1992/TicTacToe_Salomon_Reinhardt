package ui;
import spiel.Spiel;
import spieler.AISpieler;
import spieler.MenschSpieler;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UISpiel extends UIMenu{

    private Spiel spiel;
    private Scanner scanner = new Scanner(System.in);
    public UISpiel(){
        this.setMenuName("Spiel");
        this.spiel = new Spiel();
    }

    @Override
    public void zeigeDialog() {
        System.out.println("Wie möchten Sie Spielen?");
        System.out.println("1 - Spieler gegen Spieler");
        System.out.println("2 - Spieler gegen Computer");
        System.out.println("3 - Computer gegen Computer");
        loop:
        while (true){
            try {
                System.out.print("Auswahl: ");
                int eingabe = this.scanner.nextInt();
                switch (eingabe){
                    case 1 -> {
                        initialisiereSpielerVsSpieler();
                        break loop;
                    }
                    case 2 -> {
                        initialisiereSpielerVsComputer();
                        break loop;
                    }
                    case 3 -> {
                        initialisiereComputerVsComputer();
                        break loop;
                    }
                    default -> {
                        System.out.println("Auswahl nicht Möglich");
                    }
                }
            } catch (InputMismatchException ex){
                scanner.next();
                System.out.println("Bitte nur Zahlen eingeben");
            }
        }
    }

    private void initialisiereComputerVsComputer() {
        String computer1 = "AI-1";
        String computer2 = "R2D2";
        this.spiel.setSpieler(new AISpieler(computer1, 'X'), new AISpieler(computer2, 'O'));
    }

    private void initialisiereSpielerVsComputer() {
        System.out.print("Geben Sie Ihren Namen ein: ");
        String name = this.scanner.next();
        this.spiel.setSpieler(new MenschSpieler(name, 'X'), new AISpieler("Terminator", 'O'));
    }

    private void initialisiereSpielerVsSpieler(){
        System.out.print("Geben Sie Ihren Namen ein Spieler 1: ");
        String name1 = this.scanner.next();
        System.out.print("Geben Sie Ihren Namen ein Spieler 2: ");
        String name2 = this.scanner.next();
        this.spiel.setSpieler(new MenschSpieler(name1, 'X'), new  MenschSpieler(name2, 'O'));
    }

    public Spiel getSpiel(){
        return this.spiel;
    }
}
