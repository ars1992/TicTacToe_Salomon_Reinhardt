package UITests;

import org.junit.Test;
import ui.UISpiel;
import ui.UIMenu;
import java.lang.reflect.Field;

import static org.junit.Assert.*;



public class UISpielTest {

    private String menuNameUISpiel = "Spiel";




    @Test
    public void testKonstruktor() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Konstruktor-Test:");
        UIMenu spiel = new UISpiel();
        assertNotNull(spiel);
        assertTrue(spiel instanceof UISpiel);
      /*  Class<?> klass = UISpielTest.class;
       * Field erstesfield;
       * erstesfield = klass.getDeclaredField("menuNameUISpiel");          //schön wäre es.
       * spiel.setMenuName("Test");
       * String menuename =(String) erstesfield.get(spiel.getMenuName());
       */
    }



    @Test
    public void testGetSpiel(){
        UISpiel spiel = new UISpiel();
        assertNotNull(spiel.getSpiel());
        assertTrue(spiel.getSpiel() instanceof spiel.Spiel);

    }




}
