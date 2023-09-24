package spieler;
import spielfeld.Spielfeld;
import validieren.Validiere;

public class AISpieler extends Spieler{

    public AISpieler(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public int zugMachen() {
        MinMaxResult bestMove = miniMax(this.getSpielfeld(), this.getSymbol());  //einiges zu tun: spielfeld-objekt an den Spielerkonstruktor
                                                                        //mitübergebn Teil der Lösung? Sandro muss darüber gucken.
        return bestMove.getMove();
    }


    private MinMaxResult miniMax(Spielfeld spielfeld, char spieler) {

        // Überprüfen, ob das Spiel vorbei ist
        if (spielfeld.istGewonnen()) {
            if (spielfeld.istGewonnen()) {       // to-do: istGewonnenVon-methode schreiben
                return new MinMaxResult(10); // Spieler gewinnt
            } else {
                return new MinMaxResult(-10); // Gegner gewinnt
            }
        } else if (spielfeld.istUnentschieden()) {
            return new MinMaxResult(0); // Unentschieden
        }

        // Mögliche Züge generieren
        int bestMove = -1;
        int bestScore = (spieler == this.getSymbol()) ? -Integer.MAX_VALUE : Integer.MAX_VALUE;

        for (int i = 1; i <= 9; i++) {
            if (Validiere.validiereIndex(i) && Validiere.validiereObFeldFreiIst(i, spielfeld)) {
                // Zug ausprobieren
                spielfeld.setBoard(i, spieler);

                // MiniMax für den Gegner aufrufen
                MinMaxResult result = miniMax(spielfeld, (spieler == 'X') ? 'O' : 'X');

                // Zug rückgängig machen
                spielfeld.setBoard(i, (char) ('0' + i));

                // Bewertung und besten Zug aktualisieren
                if (spieler == this.getSymbol()) {
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

        return new MinMaxResult(bestScore, bestMove);
    }

    private static class MinMaxResult {
        private int score;
        private int move;

        public MinMaxResult(int score) {
            this.score = score;
        }

        public MinMaxResult(int score, int move) {
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
