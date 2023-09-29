package UITests;

import org.junit.Test;
import spiel.Spiel;
import ui.UISpiel;
import ui.UIMenu;


import static org.junit.Assert.*;

public class UISpielTest extends UITest{

    private static final String MENU_NAME = "Spiel";

    public UISpielTest(){
        super.setTest(new UISpiel(), MENU_NAME);
    }

    @Test
    public void testKonstruktor() {
        System.out.println("Konstruktor-Test:");
        UIMenu uiSpiel = new UISpiel();
        assertNotNull(uiSpiel);
        assertTrue(uiSpiel instanceof UISpiel);
    }

    @Test
    public void testGetSpiel(){
        System.out.println("TEST getSpiel");
        UISpiel spiel = new UISpiel();
        assertNotNull(spiel.getSpiel());
        assertTrue(spiel.getSpiel() instanceof Spiel);
    }
}
