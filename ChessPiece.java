import java.util.*;

/**
 * Class that is the super class of all pieces
 *
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public abstract class ChessPiece implements ChessPieceInterface
{
    // chess game
    private ChessGame game;
    private String player;
    private ChessLocation location;
    private ArrayList<ChessLocation> threateningLocations;
    // the id of the chess piece, depending on the piece
    protected char id;
   

    /**
     * Construct a piece with owner, location, and what game it is in
     * 
     * @param   owner               the owner of the piece.
     * @param   initialLocation     the first location of the piece when it is created.
     * @param   game                the game that piece is participating.
     *
     */
    public ChessPiece(String owner, ChessLocation initialLocation, ChessGame game)
    {
        player = owner;
        location = null;
        this.game = game;
        threateningLocations = new ArrayList<ChessLocation>();
        game.getBoard().placePieceAt(this, initialLocation);
    }

    /**
     * Method is using for moving the piece but the codes are mostly inside each subclass
     */
    public boolean moveTo (ChessLocation destination) 
    {
        ChessBoard board = game.getBoard();
        board.removePiece(location);
        board.placePieceAt(this, destination);
        return true;

    }
    
    protected abstract void updateThreateningLocation(ChessLocation newLocation); 

     /**
     * Check if there is blocking piece to move to destination based on piece ID
     * 
     * @param the start is the present location, and end is the desintation
     * 
     * @return true if there is a blocking piece otherwise false
     */
    protected boolean checkLineOfSight(ChessLocation start, ChessLocation end)
    {
        ChessBoard board = game.getBoard();
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();
        if ( id == 'K' || id == 'R'  || id=='Q' ) {
            if (startRow == endRow && (startCol - endCol) >0 )  
            {
                for (int i = 1; i <= Math.abs(startCol - endCol); i++)
                {
                    if (board.isPieceAt(startRow, startCol - i) == true)
                    {
                        System.out.println("there's a piece blocking your move");
                        return true;
                    }
                }
                return false;
            } else if (startRow == endRow && (startCol - endCol) < 0 )  
            {
                for (int i = 1; i <= Math.abs(startCol - endCol); i++)
                {
                    if (board.isPieceAt(startRow, startCol + i) == true)
                    {
                        System.out.println("there's a piece blocking your move");
                        return true;
                    }
                }
                return false;
            }
            if (startCol == endCol && (startRow - endRow) > 0)  
            {
                for (int i = 1; i <= Math.abs(startRow - endRow); i++)
                {
                    if (board.isPieceAt(startRow- i, startCol) == true)
                    {
                        System.out.println("there's a piece blocking your move");
                        return true;
                    }
                }
                return false;
            }
            if (startCol == endCol && (startRow - endRow) < 0)  
            {
                for (int i = 1; i <= Math.abs(startRow - endRow); i++)
                {
                    if (board.isPieceAt(startRow + i, startCol) == true)
                    {
                        System.out.println("there's a piece blocking your move");
                        return true;
                    }
                }
                return false;
            }
        } else if (id =='B' || id =='Q') 
        {
            if ((startRow - endRow ) > 0 ) 
            {
                for (int i = 1; i <= Math.abs(startRow - endRow); i++) 
                {
                    if (board.isPieceAt(endRow - i, endCol- i) == true)
                    {
                        System.out.println("there's a piece blocking your move");
                        return true;
                    }
                }
            } else if ((startRow - endRow ) < 0 ) 
            {
                for (int i = 1; i <= Math.abs(startRow - endRow); i++) 
                {
                    if (board.isPieceAt(endRow + i, endCol+ i) == true)
                    {
                        System.out.println("there's a piece blocking your move");
                        return true;
                    }
                }
            } else 
            {
                return false;
            }
        } else if ( id=='N' || id =='P') 
        {
            if (board.isPieceAt(endRow , endCol) == true)
            {
                System.out.println("there's a piece blocking your move");
                return true;
            } else
            {
                return false;
            }
        }
        return false;
    }

     /**
     * get ID of the piece
     * 
     * @return the char
     */
    protected char getID() 
    {
        return id;
    }

     /**
     * set the location
     * 
     * @param a new location
     * 
     */
    public void setLocation(ChessLocation newLocation)
    {
        location = newLocation;
    }

     /**
     * get the location
     * 
     * @return the location of piece
     * 
     */
    public ChessLocation getLocation()
    {
        return location;
    }
    
    /**
     * get the game that the piece is on
     * 
     * @return the game
     * 
     */
    public ChessGame getGame()
    {
        return game;
    }
    
    public String getPlayer()
    {
        return player;
    }
    
    public  ArrayList<ChessLocation> getThreateningLocations()
    {
        return threateningLocations;
    }

}
