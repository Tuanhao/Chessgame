
/**
 * A class that models a Rook that move in straight line on the chess board.
 * 
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class Rook extends ChessPiece
{
    /**
     * Construct a Rook piece for the game with 'R' as the piece id 
     * @param   owner               the owner of the Rook piece.
     * @param   initialLocation     the first location of Rook piece when it is created.
     * @param   game                the game that Rook piece is participating.
     */
    public Rook(String player, ChessLocation initial_location, ChessGame game)
    {
        super(player, initial_location, game);
        if (player.equals("player1")) {
            super.id = 'R';
        } else {
            super.id = 'r';
        }
    }

    /**
     * Set  piece's location to a new location 
     * This move must be horizontal or vertical otherwise print "Invalid step"
     * Place the  piece onto the chess board
     * 
     * 
     * @param   destination     The new location that  piece is heading to.
     */
    public boolean moveTo(ChessLocation destination)
    {
        int presentRow = getLocation().getRow();
        int presentCol = getLocation().getCol();
        int rowDiff = Math.abs(presentRow - destination.getRow());
        int colDiff = Math.abs(presentCol - destination.getCol());
        ChessPiece piece = super.getGame().getBoard().getPieceAt(destination);
        if (rowDiff == 0 && colDiff != 0 && !(checkLineOfSight(super.getLocation(), destination)) && !(super.getPlayer().equals(piece.getPlayer())))
        {
            super.moveTo(destination);
            super.setLocation(destination);
            return true;
        } else if (rowDiff != 0 && colDiff == 0 && !(checkLineOfSight(super.getLocation(), destination)) && !(super.getPlayer().equals(piece.getPlayer())))
        {
            super.moveTo(destination);
            super.setLocation(destination);
            return true;
        } else {  
            super.setLocation(super.getLocation());
            if(rowDiff != 0 || colDiff != 0){
                //if player put the same location as current location then this line will not be printed
                //System.out.println("Hey there, Invalid step!!!");
                return false;
            }
            return false;
        }
    }
    
    protected void updateThreateningLocation(ChessLocation newLocation)
    {
        ChessPiece piece = super.getGame().getBoard().getPieceAt(newLocation);
        if (!(piece.getPlayer().equals(super.getPlayer())) && this.moveTo(newLocation))
        {
            super.getThreateningLocations().add(newLocation);
        } else {
        }
    }
}