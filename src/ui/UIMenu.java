package ui;

public abstract class UIMenu implements UIInterface {

    private String menuName = "Menu";

    public void setMenuName(String menuName){
        this.menuName = menuName;
    }

    @Override
    public void zeigeDialog(){
        System.out.println("Menu: " + this.getMenuName());
    }

    @Override
    public String getMenuName(){
        return this.menuName;
    }

    @Override
    public boolean istBeendet(){
        return false;
    }

}
