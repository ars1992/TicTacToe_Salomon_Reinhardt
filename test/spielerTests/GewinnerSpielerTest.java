package spielerTests;
import spiel.Spiel;
import spieler.GewinnerSpieler;
import org.junit.Test;
import spieler.Spieler;
import spieler.ZufallsSpieler;
import spielfeld.Spielfeld;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class GewinnerSpielerTest extends SpielerTest{

    private String[] namen = {
            "TicTacToe-Terminator", "X-ecuter", "Xena, die X-Maschine", "BlockBuster", "TickyTacky-Troll",
            "Nullox der Nullenmeister", "KreisKönig", "O-Orakel", "O-Hexe", "Glücklicher Zufall"};

    public GewinnerSpielerTest(){
        super.setSpielerTest(new GewinnerSpieler('X'));
    }
    @Test
    public void testKonstruktor(){
        System.out.println("Konstruktor-Test:");
        Spieler testObjekt = new GewinnerSpieler('X');
        assertNotNull(testObjekt);
        assertTrue(testObjekt instanceof GewinnerSpieler);
        String name = testObjekt.getName();
        assertTrue(Arrays.asList(namen).contains(name));

    }
    @Test
    public void testGetName(){
        Spieler testObjekt = new GewinnerSpieler('X');
        System.out.println("Test der getName-Methode:");
        assertTrue(testObjekt.getName(),Arrays.asList(namen).contains(testObjekt.getName()) );
        Object resultat = testObjekt.getName();
        System.out.println("Test ob der Rückgabewert ungleich NULL und ein String ist:");
        assertTrue((resultat instanceof String) && resultat != null);
    }

    @Test
    public void testGetSymbol(){
        Spieler testObjekt = new GewinnerSpieler('X');
        System.out.println("Test der getSymbol-Methode:");
        assertEquals('X', testObjekt.getSymbol());
        Object symbol = testObjekt.getSymbol();
        assertTrue(symbol instanceof Character);
    }

    @Test
    public void testGetSpielfeld(){
        System.out.println("Test der getSpielfeld-Methode:");
        Spieler spieler = new GewinnerSpieler('X');
        Spieler spieler2 = new ZufallsSpieler('O');
        Spielfeld o = new Spielfeld();
        spieler.setSpielfeld(o);
        Spiel spiel = new Spiel();
        spiel.setSpieler(spieler, spieler2);
        assertTrue(spieler.getSpielfeld() != null);
    }
}
