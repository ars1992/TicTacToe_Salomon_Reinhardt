package ui;

public class UIBeenden extends UIMenu{

    public UIBeenden(){
        this.setMenuName("Beenden");
    }

    @Override
    public void zeigeDialog(){
        System.out.println("Vielen Dank bis zum nächsten mal.");
    }

    @Override
    public boolean istBeendet(){
        return true;
    }

}
