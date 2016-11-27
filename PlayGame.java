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
        System.out.println("The rows and columns are from 0 to 7");
        ChessGame newgame = new ChessGame("player1","player2");
        ChessBoard board = newgame.getBoard();
        board.printChessBoard();
        System.out.println("Your game is set up with player 1 and player 2.");
        boolean playing = true;
        Scanner user_input = new Scanner(System.in);

        while ( playing ){
            // ask for the row of desire location, or player can 
            // type quit to quit
            System.out.println("You have 3 options : move, reset, quit");
            System.out.println("Please type out the option you want");
            String input0 = user_input.next();
            if ("quit".equals(input0)) {
                // if the player types quit then playing will be false and while
                // loop will end.
                playing = false;
            } else if ("reset".equals(input0)) {
                ChessGame newgame = new ChessGame("player1","player2");
                ChessBoard board = newgame.getBoard();
                board.printChessBoard();
                System.out.println("Your game is reset.");
            }else if ("move".equals(input0)){
                ChessPiece check = check();
                if (check != null) {
                    System.out.println("check");
                }
                System.out.println("What is the row of your desire piece?");
                String input1 = user_input.next();
                //otherwise, player is asked for the column of desire piece
                System.out.println("What is the column of your desire piece?");
                String input2 = user_input.next();
                int row = Integer.parseInt(input1);
                int col = Integer.parseInt(input2);
                if ( row >= 0 && row <= 7 && col >= 0 && col <= 7){
                    // if the location is within the range of of the board
                    // then we move on to ask for the destination 
                    ChessLocation location = new ChessLocation(row,col);
                    ChessPiece pieceToMove = board.getPieceAt(location);
                    if (pieceToMove == null) {
                        System.out.println("Please do not choose an empty location");
                    } else {
                        System.out.println("What is the row of your desire move?");
                        String input3 = user_input.next();
                        System.out.println("What is the column of your desire move?");
                        String input4 = user_input.next();
                        int newRow = Integer.parseInt(input3);
                        int newCol = Integer.parseInt(input4);
                        if ( newRow >= 0 && newRow <= 7 && newCol >= 0 && newCol <= 7){
                            // if the location is within the range of of the board
                            // the next 3 lines will be executed which makes the piece go to new location and print the chess board
                            ChessLocation destination = new ChessLocation(newRow,newCol);
                            if (pieceToMove.moveTo(destination)) {
                                //  move is finished , let opponent make a move
                                board.printChessBoard();
                            }else{
                                //not a valid move, ask for another move
                                System.out.println("Please pick a different move.");
                            }
                        }
                    }
                }
            }else {
                // player will be asked to re enter command if it is invalid
                System.out.println("Wrong command. Please type again");
            }
        }
    }
}

