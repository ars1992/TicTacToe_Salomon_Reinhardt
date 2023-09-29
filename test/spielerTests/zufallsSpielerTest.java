package spielerTests;
import org.junit.Assert.*;
import org.junit.Test;
import spieler.MenschSpieler;
import spieler.ZufallsSpieler;

import static org.junit.Assert.*;

public class zufallsSpielerTest extends SpielerTests{

    @Test@Override
    public void testKonstruktor(){
        System.out.println("Objekt-Test:");
        ZufallsSpieler zufallTestObjekt = new ZufallsSpieler('X');
        assertEquals(zufallTestObjekt.getSymbol(),'X' );
        assertNotNull(zufallTestObjekt);
        assertNotNull(zufallTestObjekt.getName());
        assertTrue(zufallTestObjekt instanceof ZufallsSpieler);
    }


    @Override@Test
    public void testGetName(){
        ZufallsSpieler spieler = new ZufallsSpieler('X');
        System.out.println("Test der getName-Methode");
        assertNotNull(spieler.getName());
        String name = spieler.getName();
        assertTrue(name instanceof String);
    }




}
