package spieler;

/**
 * Von https://www.geeksforgeeks.org/finding-optimal-move-in-tic-tac-toe-using-minimax-algorithm-in-game-theory/
 * an unser Programm angepasst
 */
public class GewinnerSpieler extends Spieler{

    private static class Move
    {
        int row, col;
    };

    private final char PLAYER;
    private final char OPPONENT;

    public GewinnerSpieler(char symbol){
        super(symbol);
        this.PLAYER = symbol;
        String[][] namen = {
                {"TicTacToe-Terminator", "X-ecuter", "Xena, die X-Maschine", "BlockBuster", "TickyTacky-Troll"},
                {"Nullox der Nullenmeister", "KreisKönig", "O-Orakel", "O-Hexe", "Glücklicher Zufall"}
        };
        if(symbol == 'X'){
            this.OPPONENT = 'O';
            this.setName(namen[0][(int) (Math.random() * namen[0].length)]);
        } else {
            this.OPPONENT = 'X';
            this.setName(namen[1][(int) (Math.random() * namen[1].length)]);
        }
    }

    @Override
    public int zugMachen() {
        Move bestMove = findBestMove(getSpielfeld().getBoard());
        if (bestMove.row == 0) return bestMove.col + 1;
        if (bestMove.row == 1) return bestMove.col + 4;
        return bestMove.col + 7;
    }

    // This function returns true if there are moves

    // remaining on the board. It returns false if
    // there are no moves left to play.
    private boolean isMovesLeft(char[][] board)

    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if ("123456789".indexOf(board[i][j]) >= 0)
                    return true;
        return false;
    }

    // This is the evaluation function as discussed

    // in the previous article ( http://goo.gl/sJgv68 )
    private int evaluate(char[][] b)

    {
        // Checking for Rows for X or O victory.
        for (int row = 0; row < 3; row++)
        {
            if (b[row][0] == b[row][1] &&
                    b[row][1] == b[row][2])
            {
                if (b[row][0] == this.PLAYER)
                    return +10;
                else if (b[row][0] == this.OPPONENT)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col])
            {
                if (b[0][col] == this.PLAYER)
                    return +10;

                else if (b[0][col] == this.OPPONENT)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
        {
            if (b[0][0] == this.PLAYER)
                return +10;
            else if (b[0][0] == this.OPPONENT)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
        {
            if (b[0][2] == this.PLAYER)
                return +10;
            else if (b[0][2] == this.OPPONENT)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    // This is the minimax function. It considers all
    // the possible ways the game can go and returns
    // the value of the board

    private int minimax(char[][] board,
                        int depth, Boolean isMax)

    {
        int score = evaluate(board);

        // If Maximizer has won the game
        // return his/her evaluated score
        if (score == 10)
            return score;

        // If Minimizer has won the game
        // return his/her evaluated score
        if (score == -10)
            return score;

        // If there are no more moves and
        // no winner then it is a tie
        if (!isMovesLeft(board))
            return 0;

        // If this maximizer's move
        if (isMax)
        {
            int best = -1000;
            int x = 0;
            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    x++;
                    // Check if cell is empty
                    if ("123456789".indexOf(board[i][j]) >= 0)
                    {
                        // Make the move
                        board[i][j] = this.PLAYER;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = (char) ((x + 48));
                    }
                }
            }
            return best;
        }

        // If this minimizer's move
        else
        {
            int best = 1000;

            int x = 0;
            // Traverse all cells
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    x++;
                    // Check if cell is empty
                    if ("123456789".indexOf(board[i][j]) >= 0)
                    {
                        // Make the move
                        board[i][j] = this.OPPONENT;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        board[i][j] = (char) ((x + 48));
                    }
                }
            }
            return best;
        }
    }

    // This will return the best possible
    // move for the player
    private Move findBestMove(char[][] board)
    {
        int bestVal = -1000;
        Move bestMove = new Move();
        bestMove.row = -1;
        bestMove.col = -1;

        // Traverse all cells, evaluate minimax function
        // for all empty cells. And return the cell
        // with optimal value.
        int x = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                x++;
                // Check if cell is empty
                if ("123456789".indexOf(board[i][j]) >= 0)
                {
                    // Make the move
                    board[i][j] = this.PLAYER;

                    // compute evaluation function for this
                    // move.
                    int moveVal = minimax(board, 0, false);

                    // Undo the move

                    board[i][j] = (char) ((x + 48));

                    // If the value of the current move is
                    // more than the best value, then update
                    // best/
                    if (moveVal > bestVal)
                    {
                        bestMove.row = i;
                        bestMove.col = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }
}



