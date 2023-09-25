package ui;
import spiel.Spiel;
import spieler.AISpieler;
import spieler.MenschSpieler;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UISpiel extends UIMenu{

    private final Spiel SPIEL;
    private Scanner scanner = new Scanner(System.in);

    private final String[][] NAMEN = {
            {"TicTacToe-Terminator", "X-ecuter", "Xena, die X-Maschine", "BlockBuster", "TickyTacky-Troll"},
            {"Nullox der Nullenmeister", "KreisKönig", "O-Orakel", "O-Hexe", "Glücklicher Zufall"}
    };
    public UISpiel(){
        this.setMenuName("Spiel");
        this.SPIEL = new Spiel();
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
        System.out.println("Viel Spass beim Spielen");
    }

    private void initialisiereComputerVsComputer() {
        String computer1 = this.NAMEN[0][(int) (Math.random() * this.NAMEN[0].length)];
        String computer2 = this.NAMEN[1][(int) (Math.random() * this.NAMEN[1].length)];
        this.SPIEL.setSpieler(new AISpieler(computer1, 'X'), new AISpieler(computer2, 'O'));
    }

    private void initialisiereSpielerVsComputer() {
        System.out.print("Geben Sie Ihren Namen ein: ");
        String name = this.scanner.next();
        this.SPIEL.setSpieler(
                new MenschSpieler(name, 'X'),
                new AISpieler(this.NAMEN[1][(int) (Math.random() * this.NAMEN.length)], 'O')
        );
    }

    private void initialisiereSpielerVsSpieler(){
        System.out.print("Geben Sie Ihren Namen ein Spieler 1: ");
        String name1 = this.scanner.next();
        System.out.print("Geben Sie Ihren Namen ein Spieler 2: ");
        String name2 = this.scanner.next();
        this.SPIEL.setSpieler(new MenschSpieler(name1, 'X'), new MenschSpieler(name2, 'O'));
    }

    public Spiel getSpiel(){
        return this.SPIEL;
    }
}
