package ui;

public class UISpiel extends UIMenu{

    public UISpiel(){
        this.setMenuName("spiel");
    }

    @Override
    public void zeigeDialog(){
        System.out.println("Wie möchten Sie Spielen?");
        System.out.println("1 - Spieler gegen Spieler");
        System.out.println("2 - Spieler gegen Computer");
        System.out.println("3 - Computer gegen Computer");
    }

}
