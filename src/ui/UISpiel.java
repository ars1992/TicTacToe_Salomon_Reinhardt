package ui;
import spiel.Spiel;
import spieler.GewinnerSpieler;
import spieler.MenschSpieler;
import spieler.ZufallsSpieler;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UISpiel extends UIMenu{

    private final Spiel SPIEL;
    private Scanner scanner = new Scanner(System.in);


    public UISpiel(){
        this.setMenuName("Spiel");
        this.SPIEL = new Spiel();
    }

    @Override
    public void zeigeDialog() {
        System.out.println("Wie möchten Sie Spielen?");
        System.out.println("1 - Spieler gegen Spieler");
        System.out.println("2 - Spieler gegen Computer Schwer");
        System.out.println("3 - Spieler gegen Computer Leicht");
        System.out.println("4 - Computer gegen Computer");
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
                        initialisiereSpielerVsComputerSchwer();
                        break loop;
                    }
                    case 3 -> {
                        initialisiereSpielerVsComputerLeicht();
                        break loop;
                    }
                    case 4 -> {
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
        this.SPIEL.setSpieler(new GewinnerSpieler('X'), new ZufallsSpieler('O'));
    }

    private void initialisiereSpielerVsComputerSchwer() {
        char[] symbole = symbolEingeben();
        this.SPIEL.setSpieler(
                new MenschSpieler(namenEingeben(1), symbole[0]),
                new GewinnerSpieler(symbole[1])
        );
    }

    private void initialisiereSpielerVsComputerLeicht() {
        char[] symbole = symbolEingeben();
        this.SPIEL.setSpieler(
                new MenschSpieler(namenEingeben(1), symbole[0]),
                new ZufallsSpieler(symbole[1])
        );
    }
    private void initialisiereSpielerVsSpieler(){
        char[] symbole = symbolEingeben();
        this.SPIEL.setSpieler(new MenschSpieler(namenEingeben(1), symbole[0]), new MenschSpieler(namenEingeben(2), symbole[1]));
    }

    /**
     * Dialog zur Namenseingabe
     * @param spielerNummer
     * @return Eingabe des Spielers
     */
    private String namenEingeben(int spielerNummer){
        System.out.print("Geben Sie Ihren Namen ein Spieler " + spielerNummer + ": ");
        return this.scanner.next();
    }

    /**
     * Ermöglicht die auswahl eines Symbols zum Spielen
     * @return char[] mit zwei werten
     */
    private char[] symbolEingeben(){
        System.out.print("Welches Symbol möchten Sie? ('X'/'O): ");
        while (true){
            String eingabe = this.scanner.next().toUpperCase();
            if (eingabe.length() != 1 || "XO".indexOf(eingabe) < 0){
                System.out.println("Fehlerhafte eingabe bitte nur 'X' oder 'O' eingeben");
                System.out.print("Symbol eingeben: ");
                continue;
            }
            char eingabeSymbol = eingabe.charAt(0);
            if(eingabeSymbol == 'X'){
                return new char[]{'X', 'O'};
            } else {
                return new char[]{'O', 'X'};
            }
        }
    }

    public Spiel getSpiel(){
        return this.SPIEL;
    }
}
