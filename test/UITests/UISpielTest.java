package UITests;

import org.junit.Test;
import ui.UISpiel;
import ui.UIMenu;


import static org.junit.Assert.*;



public class UISpielTest {

    private String menuNameUISpiel = "Spiel";




    @Test
    public void testKonstruktor() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Konstruktor-Test:");
        UIMenu spiel = new UISpiel();
        assertNotNull(spiel);
        assertTrue(spiel instanceof UISpiel);

    }



    @Test
    public void testGetSpiel(){
        UISpiel spiel = new UISpiel();
        assertNotNull(spiel.getSpiel());
        assertTrue(spiel.getSpiel() instanceof spiel.Spiel);

    }




}
