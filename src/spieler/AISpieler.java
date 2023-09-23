package spieler;

public class AISpieler extends Spieler{

    public AISpieler(String name, char symbol){
        super(name, symbol);
    }

    @Override
    public int zugMachen() {
        return 0;
    }



}
