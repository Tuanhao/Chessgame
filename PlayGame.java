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
            System.out.println("What is the row of your next step? Or type quit to quit the game.");
            String input1 = user_input.next();
            if ("quit".equals(input1)) {
                playing = false;
            } else {
                System.out.println("What is the column of your next step?");
                String input2 = user_input.next();
                int row = Integer.parseInt(input1) -1 ; /**Need to subtract one to fit the position of the array*/
                int col = Integer.parseInt(input2) -1 ;
                if ( row >= 0 && row <= 7 && col >= 0 && col <= 7){ 
                    board.placePieceAt(knight,new ChessLocation(row,col));
                    board.printChessBoard();
                }else{
                    System.out.println("supposed from 1 to 8");
                }
            }
        }

    }
        
}
