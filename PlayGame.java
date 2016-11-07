import java.util.Scanner;
/**
 * This class contains the main function where the 
 * main while loop is.
 * 
 * @author Tuan-Hao Chau 
 * @version 07/11/16
 */
public class PlayGame
{
    public static void main(String[] args)
    {
        //create a new chess game with chess board and a knight piece.
        System.out.println("Welcome to simple chess game");
        System.out.println("This chessgame uses row and column to play manipulate the piece");
        System.out.println("The rows and columns are from 1 to 8");
        ChessGame newgame = new ChessGame("p1","p2");
        ChessBoard board = newgame.getBoard();
        board.printChessBoard();
        System.out.println("Your game is set up.");
        boolean playing = true;
        Scanner user_input = new Scanner(System.in);

        while ( playing ){
            // ask for the row of desire location, or player can 
            // type quit to quit
            System.out.println("Type move if you want to play or quit to quit the game");
            String input0 = user_input.next();
            if ("quit".equals(input0)) {
                // if the player types quit then playing will be false and while
                // loop will end.
                playing = false;
            }else if ("move".equals(input0)){
                System.out.println("What is the row of your desire piece?");
                String input1 = user_input.next();
                //otherwise, player is asked for the column of desire piece
                System.out.println("What is the column of your desire piece?");
                String input2 = user_input.next();
                int row = Integer.parseInt(input1) -1 ; /**Need to subtract one to fit the position of the array*/
                int col = Integer.parseInt(input2) -1 ;
                if ( row >= 0 && row <= 7 && col >= 0 && col <= 7){
                    // if the location is within the range of of the board
                    // then we move on to ask for the destination 
                    ChessLocation location = new ChessLocation(row,col);
                    ChessPiece pieceToMove = board.getPieceAt(location);
                    System.out.println("What is the row of your desire move?");
                    String input3 = user_input.next();
                    System.out.println("What is the column of your desire move?");
                    String input4 = user_input.next();
                    int newRow = Integer.parseInt(input3) -1 ;
                    int newCol = Integer.parseInt(input4) -1 ;
                    if ( newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7){
                        // if the location is within the range of of the board
                        // the next 3 lines will be executed which makes the piece go to new location and print the chess board
                        ChessLocation destination = new ChessLocation(newRow,newCol);
                        board.placePieceAt(pieceToMove, destination);
                        board.printChessBoard();
                    }else{
                        //otherwise, player is asked to re-enter the row and column.
                        System.out.println("supposed from 1 to 8");
                    }
                }
            } else {
                // player will be asked to re enter command if it is invalid
                System.out.println("Wrong command. Please type again");
            }
        }
    }
}
