
/**
 * Write a description of class Bishop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends ChessPiece
{
    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(String player, ChessLocation initial_location, ChessGame game)
    {
        super(player, intial_location, game);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void moveTo(ChessLocation destination)
    {
        if (destination.getRow() != this.location.getRow() && destination.getCol() != this.location.getCol() &&super.checkLineOfSight(this.location , destination)) 
        {
            super.moveTo(destination);
        } else {
            system.out.println("error- not valid move");
        }
    }
}
