
/**
 * A class that models a knight that move in L shape on the chess board.
 * 
 * @author Tuan-Hao Chau 
 * @version 08/10/16
 */
public class Knight
{
    // The game that kinght is in
    private ChessGame game;
    // The name of knight's owner
    private String owner;
    //The current location of knight
    private ChessLocation location;

    /**
     * Construct a knight piece for the game
     * @param   owner               the owner of the knight piece.
     * @param   initialLocation     the first location of knight piece when it is created.
     * @param   game                the game that knight piece is participating.
     */

    public Knight(String owner, ChessLocation initialLocation , ChessGame game)
    {
        this.owner = owner;
        this.game = game;
        this.location = initialLocation;
    }

    /**
     * Set knight piece's locaation to a new location 
     * This move must be a L shape otherwise print "Invalid step"
     * 
     * @param   newLocation     The new location that knight piece is heading to.
     */
    public void moveTo(ChessLocation newLocation) 
    {
        int newRow = newLocation.getRow() - location.getRow();
        int newCol = newLocation.getCol() - location.getCol();
        newRow = Math.abs(newRow);
        newCol = Math.abs(newCol);
        if (newRow == 2 && newCol == 1) {
            //new row is 2 tiles different and new col is 1 tile different
            // this step is valid
            this.location = newLocation;
        } else if (newRow == 1 && newCol == 2) {
            //new row is 1 tiles different and new col is 2 tile different
            // this step is also valid
            this.location = newLocation;
        } else {
            //otherwise the step is invalid, and knight piece will have the original location.
            this.location = location;
            if(newRow != 0 || newCol != 0){
                //if player put the same location as current location then this line will not be printed
                System.out.println("Hey there, Invalid step!!!");
            }
        }
    }
    
    /**
     * get the current location of the knight
     * 
     * @return a chesslocation type location.
     */
    public ChessLocation getLocation()
    {
        return location;
    }
}
