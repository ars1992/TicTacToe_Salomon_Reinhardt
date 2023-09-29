package spielerTests;
import spieler.GewinnerSpieler;
import org.junit.Test;
import spieler.MenschSpieler;
import spieler.Spieler;
import spieler.ZufallsSpieler;
import spielfeld.Spielfeld;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class AIWINTests {

/*
    //Erkenntniss: Testmethoden für die Spieler sind in diesem Fall, in keinem Fall möglich.

    @Test
    public void testMacheZug(){
        System.out.println("Testversuch des Menschspielers,der einen Zug zu machen will:");
        GewinnerSpieler kalkulator = new GewinnerSpieler('X');

        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int zug = kalkulator.zugMachen();

        assertEquals(10, zug);

        String consoleOutput = outputStream.toString().trim();
        assertFalse(consoleOutput.contains("Ungültige eingabe!"));

    }

String[][] namen = {
                {"TicTacToe-Terminator", "X-ecuter", "Xena, die X-Maschine", "BlockBuster", "TickyTacky-Troll"},
                {"Nullox der Nullenmeister", "KreisKönig", "O-Orakel", "O-Hexe", "Glücklicher Zufall"}
        }

 */

    String[] namen = {
            "TicTacToe-Terminator", "X-ecuter", "Xena, die X-Maschine", "BlockBuster", "TickyTacky-Troll",
            "Nullox der Nullenmeister", "KreisKönig", "O-Orakel", "O-Hexe", "Glücklicher Zufall"};


   // String name = namen[0][(int) (Math.random() * namen[0].length)];
   // String name2 = namen[1][(int) (Math.random() * namen[1].length)];
@Test
public void testKonstruktor(){
    System.out.println("Objekt-Test:");
    Spieler testObjekt = new GewinnerSpieler('X'); //....getSymbol());
    assertNotNull(testObjekt);
    assertTrue(testObjekt instanceof GewinnerSpieler);
    String name = testObjekt.getName();
    assertTrue(Arrays.asList(namen).contains(name));

}

    @Test
    public void testGetName(){                                       //Nur für
        Spieler testObjekt = new GewinnerSpieler( 'X');
        System.out.println("Test der getName Methode:");
        assertTrue(testObjekt.getName(),Arrays.asList(namen).contains(testObjekt.getName()) );
        Object resultat = testObjekt.getName();
        System.out.println("Test ob der Rückgabewert ungleich NULL und ein String ist:");
        assertTrue((resultat instanceof String) && resultat != null);

    }

    /*
    public void setName(){
        System.out.println("Test der setName-Methode:");    //überflüssig bzw. nicht möglich.
        Spieler testObjekt = new GewinnerSpieler( 'X');
        testObjekt.setName("Hans");
        assertEquals("Hans", testObjekt.getName());
    }*/


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
        System.out.println("Test der getSpielfeld_Methode:");
        Spieler spieler = new GewinnerSpieler('X');
        Object spielfeld  = spieler.getSpielfeld();
        assertTrue(spielfeld instanceof Spielfeld);
        assertNotNull(spielfeld);

    }


}
