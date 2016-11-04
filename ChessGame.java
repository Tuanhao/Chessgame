
/**
 * Class that creates a game that has a board and a knight.
 *
 * @author Tuan-Hao Chau 
 * @version 08/10/16
 */
public class ChessGame
{
    // the chess board of the game
    private ChessBoard board;
    //the knight piece of the game
    private Knight knight;

    /**
     * Construct a new chess board and a new knight of Player 1 with the location
     * at row 1 column 2.
     */
    public ChessGame()
    {
        board = new ChessBoard();
        knight = new Knight("player1",new ChessLocation(0,1), this);
        
    }
    
    /**
     * get the board of this game
     * 
     * @return the board in Chessboard type
     */
    public ChessBoard getBoard()
    {
        return board;
    }
    
    /**
     * Get the knight of this game
     * 
     * @return the knight in Knight type
     */
    public Knight getKnight()
    {
        return knight;
    }
}
