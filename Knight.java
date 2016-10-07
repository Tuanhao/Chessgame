
/**
 * Write a description of class Knight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight
{
    // instance variables - replace the example below with your own
    private ChessGame game;
    private String owner;
    private ChessLocation location;

    /**
     * Constructor for objects of class Knight
     */
    public Knight() {
        owner = "Player 1";
        location = new ChessLocation(0,0);
    }

    public Knight(String owner, ChessLocation initialLocation , ChessGame game)
    {
        this.owner = owner;
        this.game = game;
        this.location = initialLocation;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void moveTo(ChessLocation newLocation) 
    {
        ChessLocation temp = location;
        int row = newLocation.getRow() - location.getRow();
        int col = newLocation.getCol() - location.getCol();
        row = Math.abs(row);
        col = Math.abs(col);
        if (row == 2 && col == 1) {
            this.location = newLocation;
        } else if (row == 1 && col == 2) {
            this.location = newLocation;
        } else {
            this.location = temp;
            System.out.println("Hey there, Invalid step!!!");
        }
        //this.location = newLocation;
        /**if ((newLocation.getRow() - location.getRow() == 2 || newLocation.getRow() - location.getRow() == -2) &&( newLocation.getCol() - location.getCol() == 1 || newLocation.getCol() - location.getCol() == -1)) 
            {
                this.location = newLocation;
            }else if((newLocation.getRow() - location.getRow() == 1 || newLocation.getRow() - location.getRow() == -1)&& ( newLocation.getCol() - location.getCol() == 2 || newLocation.getCol() - location.getCol() == -2))
                {
                    this.location = newLocation;
                }else{
                    this.location = temp;
                }*/
    }
    
    public ChessLocation getLocation()
    {
        return location;
    }
}
