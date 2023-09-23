package validiererTest;

import spielfeld.Spielfeld;
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
    public void testvalidiereObFeldFreiIst(){
        System.out.println("TEST testvalidiereObFeldFreiIst");
        Validiere validiere = new Validiere();
        Spielfeld spielfeld = new Spielfeld();
        for (int i = 1; i <= 9; i++){
            Assert.assertTrue(validiere.validiereObFeldFreiIst(i, spielfeld));
        }
        char[] symbol = {'X', 'O'};
        int aktuellesSymbol = 0;
        for (int i = 1; i <= 9; i++){
            spielfeld.setBoard(i, symbol[aktuellesSymbol]);
            Assert.assertFalse(validiere.validiereObFeldFreiIst(i, spielfeld));
            aktuellesSymbol = 1 - aktuellesSymbol;
        }
    }

}
