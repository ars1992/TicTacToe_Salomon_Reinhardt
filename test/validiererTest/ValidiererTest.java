package validiererTest;

import validieren.Validiere;
import org.junit.Assert;
import org.junit.Test;


public class ValidiererTest {

    @Test
    public void testValiedireIndex(){
        System.out.println("TEST validiereIndex");
        Validiere validiere = new Validiere();
        for (int i = 1; i <= 9; i++){
            Assert.assertTrue(validiere.validiereIndex(i));
        }
        Assert.assertFalse(validiere.validiereIndex(10));
        Assert.assertFalse(validiere.validiereIndex(0));
    }

    @Test
    public void test

}
