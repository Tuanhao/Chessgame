
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight
{
    // instance variables - replace the example below with your own
    private ChessGame game;
    private String owner;
    private ChessLocation location;

    /**
     * Constructor for objects of class Knight
     */
    public Knight(String owner, ChessLocation initialLocation , ChessGame game)
    {
        this.owner = owner;
        this.game = game;
        this.location = initialLocation;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void moveTo(ChessLocation newLocation) 
    {
        Chessboard Board.removePiece(location);
        this.location = newLocation;
    }
}
