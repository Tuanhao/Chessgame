
/**
 * Class that creates the location with specific row and column.
 * 
 * @author Tuan-Hao Chau 
 * @version 08/10/16
 */
public class ChessLocation
{
    // the row of the location
    private int row;
    // the column of the location
    private int col;

    /**
     * Creating the location with specific row and column
     * @param   row     the row of the board
     * @param   col     the column of the board
     */

    public ChessLocation(int row, int col)
    {
        this.row = row;
        this.col = col;
    }


    /**
     * Get the row of the location
     * 
     * @return the row's number
     */
    public int getRow()
    {
        return row;
    }
    
     /**
     * Get the column of the location
     * 
     * @return the column's number
     */
    public int getCol()
    {
        return col;
    }
}

