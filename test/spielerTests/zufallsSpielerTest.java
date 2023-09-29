package spielerTests;
import org.junit.Assert.*;
import org.junit.Test;
import spieler.ZufallsSpieler;

import static org.junit.Assert.*;

public class zufallsSpielerTest {

    @Test
    public void testKonstruktor(){
        System.out.println("Objekt-Test:");
        ZufallsSpieler zufallTestObjekt = new ZufallsSpieler('X');
        assertEquals('X', zufallTestObjekt.getName());
        assertNotNull(zufallTestObjekt);
        assertTrue(zufallTestObjekt instanceof ZufallsSpieler);
    }




}
