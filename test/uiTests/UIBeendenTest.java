package uiTests;

import org.junit.Test;
import ui.UIBeenden;
import ui.UIMenu;
import static org.junit.Assert.*;

public class UIBeendenTest extends UITest{

    private static final String MENU_NAME = "Beenden";
    public UIBeendenTest(){
        super.setTest(new UIBeenden(), MENU_NAME);
    }

    @Test
    public void testKonstruktor() {
        System.out.println("Konstruktor-Test:");
        UIMenu beenden = new UIBeenden();
        assertNotNull(beenden);
        assertTrue(beenden instanceof UIBeenden);
    }
}