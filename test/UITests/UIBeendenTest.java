package UITests;

import org.junit.Test;
import ui.UIMenu;
import ui.UISpiel;

import static org.junit.Assert.*;

public class UIBeendenTest {


    @Test
    public void testKonstruktor() {
        System.out.println("Konstruktor-Test:");
        UIMenu beenden = new ui.UIBeenden();
        assertNotNull(beenden);
        assertTrue(beenden instanceof ui.UIBeenden);
    }


    @Test
    public void testIstBeendet(){
        System.out.println("Test der Methode testIstBeendet:");
        UIMenu beenden = new ui.UIBeenden();
        assertTrue(beenden.istBeendet());
        Object o = beenden.istBeendet();
        assertTrue(o instanceof Boolean);
    }
}