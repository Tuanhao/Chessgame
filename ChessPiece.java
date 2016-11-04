
/**
 * Write a description of class ChessPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessPiece
{
    // instance variables - replace the example below with your own
    private ChessGame game;
    private String player;
    private ChessLocation location;
    protected char id;

    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game)
    {
        player = owner;
        location = initialLocation;
        this.game = game;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void moveTo(ChessLocation newLocation)
    {
                            // check the leaglity
                            //move to new location if legal by 
                            //setting location = newlocation
    }
    
    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end)
    {
        ChessBoard board = ChessGame.getBoard();
        if (start.getRow() == end.getRow())  
        {
            for (int i = 0; i < Math.abs(start.getCol() - end.getCol()); i++)
            {
                if ( board.isPieceAt(start.getRow(), start.getCol() + i) == True) 
                { 
                    return True;
                } else if (board.isPieceAt(start.getRow(), start.getCol() - i) == True)
                {
                    return True;
                }
            }
            return False;
        }
        if (start.getCol() == end.getCol())  
        {
            for (int i = 0; i < Math.abs(start.getRow() - end.getRow()); i++)
            {
                if ( board.isPieceAt(start.getRow() + i, start.getCol()) == True) 
                { 
                    return True;
                } else if (board.isPieceAt(start.getRow()- i, start.getCol()) == True)
                {
                    return True;
                }
            }
            return False;
        }
    }
    
}
