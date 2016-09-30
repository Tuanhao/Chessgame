
/**
 * Write a description of class ChessBoard here.
 * 
 * @author  Hao 
 * @version (a version number or a date)
 */
public class ChessBoard
{
    private int Index[][] = new int[8][8];

    /**
     * Constructor for objects of class ChessBoard
     */
    public ChessBoard()
    {
        for (int row = 0; row < 8; row ++) {
            for (int col = 0; col < 8; col ++) {
                Index[row][col] = null;
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
        if (Knight.location.row == row && Knight.location.col == col) {
            return true;
        } else {
            return false;
        }
    }
    
    public void placePieceAt ( Knight knight, ChessLocation location)
    {
        knight.location.row = location.row;
        knight.location.col = location.col;
    }
    
    public void removePiece (ChessLocation location) 
    {
        location.row = null;
        location.col = null;
    }
}
