package spieler;



public class AIWin extends Spieler{

    private static class Move
    {
        int row, col;

    };

    static char player = 'X', opponent = 'O';
    public AIWin(String name, char symbol) {
        super(name, symbol);
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
                if (b[row][0] == player)
                    return +10;
                else if (b[row][0] == opponent)
                    return -10;
            }
        }

        // Checking for Columns for X or O victory.
        for (int col = 0; col < 3; col++)
        {
            if (b[0][col] == b[1][col] &&
                    b[1][col] == b[2][col])
            {
                if (b[0][col] == player)
                    return +10;

                else if (b[0][col] == opponent)
                    return -10;
            }
        }

        // Checking for Diagonals for X or O victory.
        if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
        {
            if (b[0][0] == player)
                return +10;
            else if (b[0][0] == opponent)
                return -10;
        }

        if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
        {
            if (b[0][2] == player)
                return +10;
            else if (b[0][2] == opponent)
                return -10;
        }

        // Else if none of them have won then return 0
        return 0;
    }

    // This is the minimax function. It considers all
// the possible ways the game can go and returns
// the value of the board
    private int minimax(char board[][],
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
        if (isMovesLeft(board) == false)
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
                        board[i][j] = player;

                        // Call minimax recursively and choose
                        // the maximum value
                        best = Math.max(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        //board[i][j] = '_';
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
                        board[i][j] = opponent;

                        // Call minimax recursively and choose
                        // the minimum value
                        best = Math.min(best, minimax(board,
                                depth + 1, !isMax));

                        // Undo the move
                        //board[i][j] = '_';
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
                    board[i][j] = player;

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



