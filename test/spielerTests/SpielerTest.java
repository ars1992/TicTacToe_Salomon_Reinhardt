package spielerTests;

import org.junit.Test;
import spieler.MenschSpieler;
import spieler.Spieler;
import spieler.ZufallsSpieler;
import spielfeld.Spielfeld;
import static org.junit.Assert.*;

public abstract class SpielerTest {

    @Test
    public  void testKonstruktor(){
        System.out.println("Objekt-Test:");
        Spieler testObjekt = new MenschSpieler("Pascal",'X');
        assertNotNull(testObjekt);
        assertTrue(testObjekt instanceof MenschSpieler);
    }


    @Test
    public void testGetName(){
        Spieler testObjekt = new MenschSpieler( "Marco",'X');
        System.out.println("Test der getName Methode:");
        assertEquals("Hans", testObjekt.getName());
        Object resultat = testObjekt.getName();
        System.out.println("Test ob der Rückgabewert ungleich NULL und ein String ist:");
        assertTrue((resultat instanceof String) && resultat != null);

    }

    public void setName(){
        System.out.println("Test der setName-Methode:");
        Spieler testObjekt = new MenschSpieler("Fabian", 'X');
        testObjekt.setName("Hans");
        assertEquals("Hans", testObjekt.getName());
    }

    @Test
    public void testGetSymbol(){
        Spieler testObjekt = new ZufallsSpieler('X');
        System.out.println("Test der getSymbol-Methode:");
        assertEquals('X', testObjekt.getSymbol());
        Object symbol = testObjekt.getSymbol();
        assertTrue(symbol instanceof Character);

    }

    @Test
    public void testGetSpielfeld(){
        System.out.println("Test der getSpielfeld_Methode:");
        Spieler spieler = new MenschSpieler("Sandro_der_abstrakte_Schlächter",'X');
        Object spielfeld  = spieler.getSpielfeld();
        assertTrue(spielfeld instanceof Spielfeld);
        assertNotNull(spielfeld);

        }


        @Test
    public void testSetSpielfeld(){
        Spieler menschSpieler = new MenschSpieler("Marco", 'X');
        System.out.println("Test setSpielfeld:");
        //Nicht möglich oder Sandro muss ran.
    }
}
