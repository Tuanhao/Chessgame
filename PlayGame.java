import java.util.Scanner;
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
        newgame.board.placePieceAt(newgame.knight, (1,0) );
        //newgame.knight = new Knight("Player 1",(1,0),newgame);
        System.out.println("Your game is set up. Knight is now at [0,1].");
        playing:
        while ( true ){
            System.out.println(" what is the row of your next step? Or type quit to quit the game.");
            input1 = user_input.next();
            if (input1.trim() == "quit") {
                break playing;
            } else {
                System.out.println(" what is the column of your next step?");
                input2 = user_input.next();
            }
            int row = Integer.parseInt(input1);
            int col = Integer.parseInt(input2);
            newknight.moveTo(row,col);
        }

    }
        
}
