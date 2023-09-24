package validiererTest;

import spielfeld.Spielfeld;
import validieren.Validiere;
import org.junit.Assert;
import org.junit.Test;


public class ValidiererTest {

    @Test
    public void testValiedireIndex(){
        System.out.println("TEST validiereIndex");
        for (int i = 1; i <= 9; i++){
            Assert.assertTrue(Validiere.validiereIndex(i));
        }
        Assert.assertFalse(Validiere.validiereIndex(10));
        Assert.assertFalse(Validiere.validiereIndex(0));
    }

    @Test
    public void testvalidiereObFeldFreiIst(){
        System.out.println("TEST testvalidiereObFeldFreiIst");
        Spielfeld spielfeld = new Spielfeld();
        for (int i = 1; i <= 9; i++){
            Assert.assertTrue(Validiere.validiereObFeldFreiIst(i, spielfeld));
        }
        System.out.println(spielfeld);
        char[] symbol = {'X', 'O'};
        int aktuellesSymbol = 0;
        for (int i = 1; i <= 9; i++){
            spielfeld.setBoard(i, symbol[aktuellesSymbol]);
            Assert.assertFalse(Validiere.validiereObFeldFreiIst(i, spielfeld));
            aktuellesSymbol = 1 - aktuellesSymbol;
        }
        System.out.println(spielfeld);
    }

}
