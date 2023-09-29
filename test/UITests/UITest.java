package UITests;

import org.junit.Assert;
import org.junit.Test;
import ui.UIBeenden;
import ui.UIMenu;

public abstract class UITest {

    private UIMenu menu = null;
    private String menuName = null;

    public void setTest(UIMenu menu, String menuName){
        this.menu = menu;
        this.menuName = menuName;
    }

    @Test
    public void testSetMenuName(){
        System.out.println("TEST setMenuName");
        Assert.assertEquals(this.menu.getMenuName(), this.menuName);
        this.menu.setMenuName("TEST");
        Assert.assertEquals(this.menu.getMenuName(), "TEST");
    }

    @Test
    public void testGetMenuName(){
        System.out.println("TEST getMenuName");
        Assert.assertEquals(this.menu.getMenuName(), this.menuName);
        Assert.assertNotNull(this.menu.getMenuName());
    }

    @Test
    public void testIstBeendet(){
        System.out.println("TEST istBeendet");
        if (this.menu instanceof UIBeenden){
            Assert.assertTrue(this.menu.istBeendet());
        } else {
            Assert.assertFalse(this.menu.istBeendet());
        }
    }
}
