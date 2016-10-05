
/**
 * Write a description of class ChessBoard here.
 * 
 * @author  Hao 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    private Integer board[][] = new Integer[8][8];

    /**
     * Constructor for objects of class Chessboard
     */
    public ChessBoard()
    {
        for (int row = 0; row < 8; row ++) {
            System.out.println("");
            for (int col = 0; col < 8; col ++) {
                board[row][col] = null;
                System.out.print(" - ");
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean isPieceAt(int row,  int col)
    {
        if (board[row][col] != null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void placePieceAt ( Knight knight, ChessLocation location)
    {
        board[location.getRow()][location.getCol()] = 1;
        knight.moveTo(location);
    }
    
    public void removePiece (ChessLocation location) 
    {
        board[location.getRow()][location.getCol()] = null;
    }
    
    public void printChessBoard() 
    {
        for (int row = 0; row < 8; row ++) {
            System.out.println("");
            for (int col = 0; col < 8; col ++) {
                if (board[row][col] == 1) {
                System.out.print(" K ");
            }else {
                System.out.print(" - ");
            }
            }
        }
    }

    
}
