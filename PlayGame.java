import java.util.Scanner;
/**
 * This class contains the main function where the 
 * main while loop is.
 * 
 * @author Tuan-Hao Chau 
 * @version 08/10/16
 */
public class PlayGame
{
    public static void main(String[] args)
    {
        //create a new chess game with chess board and a knight piece.
        System.out.println("Welcome to simple chess game");
        ChessGame newgame = new ChessGame();
        ChessBoard board = newgame.getBoard();
        Knight knight = newgame.getKnight();
        board.placePieceAt(knight, knight.getLocation());
        board.printChessBoard();
        System.out.println("Your game is set up. Knight is now at [0,1].");
        System.out.println("K represents your knight and - represents empty tile.");
        boolean playing = true;
        Scanner user_input = new Scanner(System.in);
        
        while ( playing ){
            // ask for the row of desire location, or player can 
            // type quit to quit
            System.out.println("What is the row of your next step? Or type quit to quit the game.");
            String input1 = user_input.next();
            if ("quit".equals(input1)) {
                // if the player types quit then playing will be false and while
                // loop will end.
                playing = false;
            } else {
                //otherwise, player is asked for the column of desire location
                System.out.println("What is the column of your next step?");
                String input2 = user_input.next();
                int row = Integer.parseInt(input1) -1 ; /**Need to subtract one to fit the position of the array*/
                int col = Integer.parseInt(input2) -1 ;
                if ( row >= 0 && row <= 7 && col >= 0 && col <= 7){
                    // if the location is within the range of of the board
                    // the next 2 lines will be executed
                    board.placePieceAt(knight,new ChessLocation(row,col));
                    board.printChessBoard();
                }else{
                    //otherwise, player is asked to re-enter the row and column.
                    System.out.println("supposed from 1 to 8");
                }
            }
        }

    }
        
}
