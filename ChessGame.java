
/**
 * Class that creates a game that has a board and all the pieces.
 *
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class ChessGame
{
    // the chess board of the game
    private ChessBoard board;
    //the player 1 
    private String player1;
    // player 2
    private String player2;

    /**
     * Construct a new chess board and all the pieces for Player 1 with the location
     * 
     * @param player 1 and player 2
     */
    public ChessGame(String player1, String player2)
    {
        board = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
        new Rook(player1,new ChessLocation(0,0), this);
        new Rook(player1,new ChessLocation(0,7), this);
        new Knight(player1,new ChessLocation(0,1), this);
        new Knight(player1,new ChessLocation(0,6), this);
        new Bishop(player1,new ChessLocation(0,2), this);
        new Bishop(player1,new ChessLocation(0,5), this);
        new Queen(player1,new ChessLocation(0,3), this);
        new King(player1,new ChessLocation(0,4), this);
        for (int i = 0; i <8; i++) 
        {
            new Pawn(player1,new ChessLocation(1,i), this);
        }
        new Rook(player2,new ChessLocation(7,0), this);
        new Rook(player2,new ChessLocation(7,7), this);
        new Knight(player2,new ChessLocation(7,1), this);
        new Knight(player2,new ChessLocation(7,6), this);
        new Bishop(player2,new ChessLocation(7,2), this);
        new Bishop(player2,new ChessLocation(7,5), this);
        new Queen(player2,new ChessLocation(7,3), this);
        new King(player2,new ChessLocation(7,4), this);
        for (int i = 0; i <8; i++) 
        {
            new Pawn(player2,new ChessLocation(6,i), this);
        }
    }
    
    /**
     * get the board of this game
     * 
     * @return the board in Chessboard type
     */
    public ChessBoard getBoard()
    {
        return board;
    }
    
    public String nextPlayer(String curPlayer)
    {
        if (curPlayer.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }
    
}
