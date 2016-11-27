
/**
 * A class that models a Queen that move horizontally, vertically, and diagonally on the chess board.
 * 
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class Queen extends ChessPiece
{
     /**
     * Construct a queen piece for the game with 'Q' as the piece id 
     * @param   owner               the owner of the queen piece.
     * @param   initialLocation     the first location of queen piece when it is created.
     * @param   game                the game that queen piece is participating.
     */
    public Queen(String player, ChessLocation initial_location, ChessGame game)
    {
        super(player, initial_location, game);
        if (player.equals("player1")) {
            super.id = 'Q';
        } else {
            super.id = 'q';
        }
    }

    /**
     * Set  piece's location to a new location 
     * This move must be horizontal or vertical or diagonal otherwise print "Invalid step"
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
        if (rowDiff == colDiff && !(checkLineOfSight(super.getLocation(), destination)))
        {
            super.setLocation(destination);
        } else if (rowDiff == 0 || colDiff == 0)
        {
            if (!(checkLineOfSight(super.getLocation(), destination)))
            {
                super.setLocation(destination);
            }
        } else 
        {   
            super.setLocation(super.getLocation());
            if(rowDiff != 0 || colDiff != 0)
            {
                //if player put the same location as current location then this line will not be printed
                System.out.println("Hey there, Invalid step!!!");
            }
        }
        super.getGame().getBoard().getSquare()[getLocation().getRow()][getLocation().getCol()] = this;
    }
}