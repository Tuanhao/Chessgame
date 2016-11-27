
/**
 * A class that models a Pawn that move 1 step a time (except for first move) on the chess board.
 * 
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class Pawn extends ChessPiece
{
    public boolean firstMove;
    /**
     * Construct a pawn piece for the game with 'N' as the piece id 
     * @param   owner               the owner of the Pawn piece.
     * @param   initialLocation     the first location of pawn piece when it is created.
     * @param   game                the game that pawn piece is participating.
     */
    public Pawn(String player, ChessLocation initial_location, ChessGame game)
    {
        super(player, initial_location, game);
        if (player.equals("player1")) {
            super.id = 'P';
        } else {
            super.id = 'p';
        }
        firstMove = false;
    }

    /**
     * Set  piece's location to a new location 
     * This move must be straight ahead otherwise print "Invalid step"
     * Place the  piece onto the chess board
     * First move can move one or two steps, after that only one step is allowed
     * 
     * @param   destination     The new location that  piece is heading to.
     */
    public boolean moveTo(ChessLocation destination)
    {
        int presentRow = super.getLocation().getRow();
        int presentCol = super.getLocation().getCol();
        ChessPiece piece = super.getGame().getBoard().getPieceAt(destination);
        int rowDiff = presentRow - destination.getRow();
        int colDiff = presentCol - destination.getCol();
        if (super.getPlayer().equals("player1")) {
            rowDiff = -rowDiff;
            colDiff = -colDiff;
        }
        if (firstMove)
        {
            if ( rowDiff ==1 && !(checkLineOfSight(super.getLocation(), destination)))
            {
                super.setLocation(destination);
                super.moveTo(destination);
            } else if (rowDiff ==1  && colDiff ==1 && !(super.getPlayer().equals(piece.getPlayer())))
            {
                super.setLocation(destination);
                super.moveTo(destination);
            } else {   
                super.setLocation(super.getLocation());
                if(rowDiff != 0 || colDiff != 0){
                    //if player put the same location as current location then this line will not be printed
                    System.out.println("Hey there, Invalid step!!!");
                    return false;
                }
                return false;
            }
        } else {
            if (rowDiff == 1 || rowDiff == 2) {
                super.setLocation(destination);
                firstMove = true;
                super.moveTo(destination);
            }else if (rowDiff ==1  && colDiff ==1 && !(super.getPlayer().equals(piece.getPlayer()))) 
            {
                 super.setLocation(destination);
                firstMove = true;
                super.moveTo(destination);
            }else 
            {   
                super.setLocation(super.getLocation());
                if(rowDiff != 0 || colDiff != 0){
                    //if player put the same location as current location then this line will not be printed
                    System.out.println("Hey there, Invalid step!!!");
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    protected void updateThreateningLocation(ChessLocation newLocation)
    {
        ChessPiece piece = super.getGame().getBoard().getPieceAt(newLocation);
        if (!(piece.equals(super.getPlayer())) && super.moveTo(newLocation))
        {
            super.getThreateningLocations().add(newLocation);
        } else {
        }
    }
}