package validiererTest;

import validieren.Validiere;
import org.junit.Assert;
import org.junit.Test;


public class ValidiererTest {

    public void testValiedireIndex(){
        Validiere validiere = new Validiere();
        for (int i = 1; i <= 9; i++){
            Assert.assertTrue(validiere.validiereIndex(i));
        }
    }

}
