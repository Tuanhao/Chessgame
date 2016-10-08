
/**
 * Write a description of class ChessLocation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChessLocation
{
    // instance variables - replace the example below with your own
    private int row;
    private int col;
    //private int location[] = new int [2];

    /**
     * Constructor for objects of class ChessLocation
     */

    public ChessLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getRow()
    {
        return row;
    }
    public int getCol()
    {
        return col;
    }
}

