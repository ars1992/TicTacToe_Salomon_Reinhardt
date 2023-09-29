package spielerTests;

import org.junit.*;
import spieler.MenschSpieler;
import spieler.Spieler;

import static org.junit.Assert.*;

public class MenschSpielerTest extends SpielerTest{

    public MenschSpielerTest(){
        super.setSpielerTest(new MenschSpieler("Ludgar", 'O'));
    }

    @Test
    public void testGetSymbol(){
        Spieler testObjekt = new MenschSpieler("Christoph", 'X');
        System.out.println("Test der getSymbol-Methode:");
        assertEquals('X', testObjekt.getSymbol());
        Object symbol = testObjekt.getSymbol();
        assertTrue(symbol instanceof Character);
    }
}
