
/**
 * A class that models a knight that move in L shape on the chess board.
 * 
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class Knight extends ChessPiece 
{

    /**
     * Construct a knight piece for the game
     * @param   owner               the owner of the knight piece.
     * @param   initialLocation     the first location of knight piece when it is created.
     * @param   game                the game that knight piece is participating.
     */

    public Knight(String owner, ChessLocation initialLocation , ChessGame game)
    {
        super(owner, initialLocation, game);
        if (player.equals("player1")) {
            super.id = 'N';
        } else {
            super.id = 'n';
        }
    }

    /**
     * Set knight piece's location to a new location 
     * This move must be a L shape otherwise print "Invalid step"
     * Place the Knight piece onto the chess board
     * 
     * @param   destination     The new location that knight piece is heading to.
     */
    public void moveTo(ChessLocation destination) 
    {
        int presentRow = super.getLocation().getRow();
        int presentCol = super.getLocation().getCol();
        int rowDiff = Math.abs(presentRow - destination.getRow());
        int colDiff = Math.abs(presentCol - destination.getCol());
        if (rowDiff == 2 && colDiff == 1 && !(checkLineOfSight(super.getLocation(), destination))) {
            //new row is 2 tiles different and new col is 1 tile different
            // this step is valid
            super.setLocation(destination);
        } else if (rowDiff == 1 && colDiff == 2 && !(checkLineOfSight(super.getLocation(), destination))) {
            //new row is 1 tiles different and new col is 2 tile different
            // this step is also valid
            super.setLocation(destination);
        } else {
            //otherwise the step is invalid, and knight piece will have the original location.
            super.setLocation(destination);
            if(rowDiff != 0 || colDiff != 0){
                //if player put the same location as current location then this line will not be printed
                System.out.println("Hey there, Invalid step!!!");
            }
        }
        super.getGame().getBoard().getSquare()[getLocation().getRow()][getLocation().getCol()] = this;
    }
}
