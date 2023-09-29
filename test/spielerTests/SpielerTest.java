package spielerTests;

import org.junit.Assert;
import org.junit.Test;
import spieler.MenschSpieler;
import spieler.Spieler;
import spieler.ZufallsSpieler;
import spielfeld.Spielfeld;
import ui.UIMenu;

import static org.junit.Assert.*;

public abstract class SpielerTest {

    private Spieler spieler = null;

    public void setSpielerTest(Spieler spieler){
        this.spieler = spieler;
    }

    @Test
    public void testSetAndGetSpielfeld(){
        System.out.println("TEST setAndGetSpielfeld");
        Spielfeld spielfeld = new Spielfeld();
        this.spieler.setSpielfeld(spielfeld);
        Assert.assertTrue(this.spieler.getSpielfeld() instanceof Spielfeld);
        Assert.assertNotNull(this.spieler.getSpielfeld());
    }

    @Test
    public void testSetAndGetName(){
        System.out.println("TEST setAndGetName");
        this.spieler.setName("HANS");
        Assert.assertEquals(this.spieler.getName(), "HANS");
    }
}
