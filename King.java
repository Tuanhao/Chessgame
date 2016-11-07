
/**
 * A class that models a King that can only move 1 step on the chess board.
 * 
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class King extends ChessPiece
{
    /**
     * Construct a King piece for the game with 'K' as the piece id 
     * @param   owner               the owner of the King piece.
     * @param   initialLocation     the first location of King piece when it is created.
     * @param   game                the game that King piece is participating.
     */
    public King(String player, ChessLocation initial_location, ChessGame game)
    {
        super(player, initial_location, game);
        super.id = 'K';
    }

    /**
     * Set  piece's location to a new location 
     * This move can only be 1 step any where surrond the piece otherwise print "Invalid step"
     * Place the  piece onto the chess board
     * 
     * 
     * @param   destination     The new location that  piece is heading to.
     */
    public void moveTo(ChessLocation destination)
    {
        int presentRow = super.getLocation().getRow();
        int presentCol = super.getLocation().getCol();
        int rowDiff = Math.abs(presentRow - destination.getRow());
        int colDiff = Math.abs(presentCol - destination.getCol());
        if ((rowDiff == 1 || colDiff ==1) && !(checkLineOfSight(super.getLocation(), destination)))
        {
            super.setLocation(destination);
        } else 
        {   
            super.setLocation(super.getLocation());
            if(rowDiff != 0 || colDiff != 0){
                //if player put the same location as current location then this line will not be printed
                System.out.println("Hey there, Invalid step!!!");
            }
        }
        super.getGame().getBoard().getSquare()[getLocation().getRow()][getLocation().getCol()] = this;
    }
}