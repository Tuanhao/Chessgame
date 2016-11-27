
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
        if (player.equals("player1")) {
            super.id = 'K';
        } else {
            super.id = 'k';
        }
    }

    /**
     * Set  piece's location to a new location 
     * This move can only be 1 step any where surrond the piece otherwise print "Invalid step"
     * Place the  piece onto the chess board
     * 
     * 
     * @param   destination     The new location that  piece is heading to.
     */
    public boolean moveTo(ChessLocation destination)
    {
        int presentRow = super.getLocation().getRow();
        int presentCol = super.getLocation().getCol();
        int rowDiff = Math.abs(presentRow - destination.getRow());
        int colDiff = Math.abs(presentCol - destination.getCol());
        if ((rowDiff == 1 || colDiff ==1) && !(checkLineOfSight(super.getLocation(), destination)) && !(super.getPlayer().equals(getPieceAt(desitination).getPlayer())))
        {
            super.setLocation(destination);
            super.moveTo(destination);
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
    
    public void updateThreateningLocation(ChessLocation newLocation)
    {
        ChessPiece piece = getPieceAt(newLocation);
        if (!(piece.getPlayer().equals(super.getPlayer())) && super.moveTo(newLocation))
        {
            super.getThreateningLocation.add(newLocation);
        } else {
        }
    }
    
    public ChessPiece locationInDanger(ChessLocation destinationLocation)
    {
        ChessBoard board = this.getGame().getBoard();
        for (int x = 0; x < 8; i++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y] != null) 
                {
                    ChessPiece piece = getPieceAt(ChessLocation(x,y));
                    piece.updateThreateningLocation(destinationLocation);
                    if (piece.getThreateningLocation.conatins(super.getLocation()))
                    {
                        return piece;
                    }
                }
            }
        }
        return null;
    }
    
    public boolean anyMovesLeft()
    {
        ChessBoard board = super.getGame().getBoard();
        int row = super.getLocation().getRow();
        int col = super.getLocation().getCol();
        for (int x = -1; x < 2; x++ )
        {
            for (int y = -1; y < 2; y++ )
            {
                if (this.moveTo(ChessLocation(row, col)) && board[row+x][col+y] == null && this.locationInDanger(ChessLocation(row, col)) == null)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public ChessPiece check()
    {
        if (this.locationInDanger(super.getLocation()) == null)
        {
            return null;
        } else {
            return this.locationInDanger(super.getLocation());
        }
    }
}