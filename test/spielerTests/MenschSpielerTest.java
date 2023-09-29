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

    @Test
    public void testGetSymbol(){
        Spieler testObjekt = new MenschSpieler("Christoph", 'X');
        System.out.println("Test der getSymbol-Methode:");
        assertEquals('X', testObjekt.getSymbol());
        Object symbol = testObjekt.getSymbol();
        assertTrue(symbol instanceof Character);
    }


}
