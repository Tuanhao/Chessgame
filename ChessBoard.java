
/**
 * A simple model of a chess board. 
 * The board will be filled with piece for player to move.
 * 
 * @author  Hao 
 * @version 08/10/16
 */
public class ChessBoard
{
    // An array that is 8 by 8 in Knight type.
    private ChessPiece board[][] = new ChessPiece[8][8];

    /**
     * Create the chessboard and initialize every tile with null
     */
    public ChessBoard()
    {
        for (int row = 0; row < 8; row ++) {
            for (int col = 0; col < 8; col ++) {
                board[row][col] = null;
            }
        }
    }

    /**
     * Check if there is a piece at specific row and column.
     * 
     * @param   row   the specific row on the board
     * @param   col   the specific column on the board
     * 
     * @return     true if there is a piece, otherwise false.
     */
    public boolean isPieceAt(int row,  int col)
    {
        if (board[row][col] != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public ChessPiece getPieceAt(ChessLocation location)
    {
        return ChessPiece.getPiece(location.getRol(),location.getCol());
    }
    
    /**
     * Place a knight piece at specific location 
     * by removing the current knight piece on the board and place it at the new location
     * 
     * @param   knight      the knight about to move
     * @param   location    the new location 
     */
    public void placePieceAt ( ChessPiece piece, ChessLocation location)
    {
        ChessLocation curLocation = piece.getLocation();
        removePiece(curLocation);
        piece.moveTo(location);
        ChessLocation nextLocation = piece.getLocation();
        board[nextLocation.getRow()][nextLocation.getCol()] = piece;
    }
    
    /**
     * Remove the piece at a specific location by setting that tile to null(empty)
     * 
     * @param    location    the location of tile that needs to be clear
     */
    public void removePiece (ChessLocation location) 
    {
        board[location.getRow()][location.getCol()] = null;
    }
    
    /**
     * Print the chess board
     * Print "K" to indicate the tile is not empty, otherwise "-"
     */
    public void printChessBoard() 
    {
        for (int row = 0; row < 8; row ++) {
            System.out.println("");
            for (int col = 0; col < 8; col ++) {
                if (board[row][col] != null) {
                    System.out.print(" K ");
                }else {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println("");
    }
}
