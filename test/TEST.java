import org.junit.Assert;
import org.junit.Test;
import spielfeld.Spielfeld;

public class TEST {

    
    @Test
    public void test(){
        System.out.println("Erster Test");
        Spielfeld s = new Spielfeld();
        Assert.assertTrue(s.test());
    }

}
