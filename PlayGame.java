
/**
 * Write a description of class PlayGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayGame
{
    public static void main(String[] args)
    {
        System.out.println("Simple chess game");
        ChessGame newgame = new ChessGame();
        newgame.board.printChessBoard();
        for ( int i = 1; i != 0; i++) { 
        System.out.println(" what is the row of your next step?");
        String row = System.in.readln();
        if (row == "quit") {i = 0}
        else {
        System.out.println(" what is the column of your next step?");
        String col = System.in.readln();
        newgame.knight
    }
        
}
