package spieler;
import spielfeld.Spielfeld;
import validieren.Validiere;

public class AISpieler extends Spieler{

    public AISpieler(String name, char symbol, Spielfeld spielfeld){
        super(name, symbol, spielfeld);
    }



    @Override
    public int zugMachen() {
        MiniMaxResult bestMove = miniMax(this.getSpielfeld(), this.getSymbol());  //einiges zu tun: spielfeld-objekt an den Spielerkonstruktor
                                                                        //mitübergebn Teil der Lösung? Sandro muss darüber gucken.
        return bestMove.getMove();
    }


    private MiniMaxResult miniMax(Spielfeld spielfeld, char player) {
        Validiere validator = new Validiere();

        // Überprüfen, ob das Spiel vorbei ist
        if (spielfeld.istGewonnen()) {
            if (spielfeld.istGewonnen()) {       // to-do: istGewonnenVon-methode schreiben
                return new MiniMaxResult(10); // Spieler gewinnt
            } else {
                return new MiniMaxResult(-10); // Gegner gewinnt
            }
        } else if (spielfeld.istUnentschieden()) {
            return new MiniMaxResult(0); // Unentschieden
        }

        // Mögliche Züge generieren
        int bestMove = -1;
        int bestScore = (player == this.getSymbol()) ? -Integer.MAX_VALUE : Integer.MAX_VALUE;

        for (int i = 1; i <= 9; i++) {
            if (validator.validiereIndex(i) && validator.validiereObFeldFreiIst(i, spielfeld)) {
                // Zug ausprobieren
                spielfeld.setBoard(i, player);

                // MiniMax für den Gegner aufrufen
                MiniMaxResult result = miniMax(spielfeld, (player == 'X') ? 'O' : 'X');

                // Zug rückgängig machen
                spielfeld.setBoard(i, (char) ('0' + i));

                // Bewertung und besten Zug aktualisieren
                if (player == this.getSymbol()) {
                    if (result.getScore() > bestScore) {
                        bestScore = result.getScore();
                        bestMove = i;
                    }
                } else {
                    if (result.getScore() < bestScore) {
                        bestScore = result.getScore();
                        bestMove = i;
                    }
                }
            }
        }

        return new MiniMaxResult(bestScore, bestMove);
    }

    private static class MiniMaxResult {
        private int score;
        private int move;

        public MiniMaxResult(int score) {
            this.score = score;
        }

        public MiniMaxResult(int score, int move) {
            this.score = score;
            this.move = move;
        }

        public int getScore() {
            return score;
        }

        public int getMove() {
            return move;
        }
    }



}
