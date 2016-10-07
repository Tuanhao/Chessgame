
/**
 * Write a description of class ChessGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessGame
{
    // instance variables - replace the example below with your own
    public ChessBoard board;
    private Knight knight;

    /**
     * Constructor for objects of class ChessGame
     */
    public ChessGame()
    {
        board = new ChessBoard();
        knight = new Knight("player1",new ChessLocation(0,1), this);
        
    }
    
    public ChessBoard getBoard()
    {
        return board;
    }
    
    public Knight getKnight()
    {
        return knight;
    }
}
