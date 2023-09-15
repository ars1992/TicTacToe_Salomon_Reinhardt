import spielfeld.Spielfeld;

public class Main {
    public static void main(String[] args) {
        Spielfeld s = new Spielfeld();
        System.out.println(s);
        System.out.println(s);
        System.out.println(s.istGewonnen());
    }
}