
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
        ChessPiece piece = super.getGame().getBoard().getPieceAt(destination);
        if ((rowDiff == 1 || colDiff ==1) && !(checkLineOfSight(super.getLocation(), destination)) && !(super.getPlayer().equals(piece.getPlayer())))
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

    public void updateThreateningLocation(ChessLocation newLocation)
    {
        ChessPiece piece = super.getGame().getBoard().getPieceAt(newLocation);
        if (!(piece.getPlayer().equals(super.getPlayer())) && this.moveTo(newLocation))
        {
            super.getThreateningLocations().add(newLocation);
        } else {
        }
    }

    public ChessPiece locationInDanger(ChessLocation destinationLocation)
    {
        ChessPiece[][] board = this.getGame().getBoard().getSquare();
        for (int x = 0; x < 8; x++)
        {
            for (int y = 0; y < 8; y++)
            {
                if (board[x][y] != null) 
                {
                    ChessPiece piece = board[x][y];
                    piece.updateThreateningLocation(destinationLocation);
                    if (piece.getThreateningLocations().contains(super.getLocation()))
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
        ChessPiece[][] board = super.getGame().getBoard().getSquare();
        int row = super.getLocation().getRow();
        int col = super.getLocation().getCol();
        for (int x = -1; x < 2; x++ )
        {
            for (int y = -1; y < 2; y++ )
            {
                if (x+row <0 || col+y < 0 || x+row >7 || col+y >7) {
                } else {
                    ChessLocation dest = new ChessLocation(row,col);
                    if (this.moveTo(dest) && board[row+x][col+y] == null && this.locationInDanger(dest) == null)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ChessPiece check()
    {
        ChessPiece piece = this.locationInDanger(super.getLocation());
        if (piece == null)
        {
            return null;
        } else {
            return piece;
        }
    }
    
}