package spielerTests;

import org.junit.*;
import spieler.MenschSpieler;
import spieler.Spieler;
import spieler.ZufallsSpieler;

import java.util.Scanner;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenschSpielerTest extends SpielerTests {
/*
    @Test
    public void testMacheZug(){
        System.out.println("Testversuch des Menschspielers,der einen Zug zu machen will:");     // Erkenntnis: Scanner verunmöglicht die Ausführung einer Test-Methode.
        MenschSpieler mensch = new MenschSpieler("Yury", 'X');
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        int zug = mensch.zugMachen();

        assertEquals(10, zug);

        String consoleOutput = outputStream.toString().trim();
        assertFalse(consoleOutput.contains("Ungültige eingabe!"));

    }
*/
    @Test @Override
    public void testGetSymbol(){
        Spieler testObjekt = new MenschSpieler("Christoph", 'X');
        System.out.println("Test der getSymbol-Methode:");
        assertEquals('X', testObjekt.getSymbol());
        Object symbol = testObjekt.getSymbol();
        assertTrue(symbol instanceof Character);
    }


}
