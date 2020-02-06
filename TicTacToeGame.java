import java.util.*;
import java.io.*;
import java.lang.*;


public class TicTacToeGame {



        public static void main(String[] args) throws IOException {
            TicTacToeGame();
        }

         public static int[][] createBoard() {
             //board instantiation
             int[][] board = new int[3][3];
             for(int i  = 0; i < board.length; i++) {
                 for(int j  = 0; j < board[i].length; j++) {
                     board[i][j] = 0;
                 }
             }
             return board;
         }

        public static void printBoard( int[][] board) {
            for(int i  = 0; i < board.length; i++) {
                for(int j  = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

        public static boolean boardResultCheck(int[][] board) {
            //8 conditions for winning/tie

            //diagonal check
            if (  board[2][0] != 0 && board[2][0]  == board[1][1] &&  board[1][1] == board[0][2]) {
                //diagonal win
                System.out.println("WEIRD DIAGONAL WIN");

                return true;
            }
            if ( board[0][0] != 0 && board[0][0]  == board[1][1] &&  board[1][1] == board[2][2]) {
                //diagonal win
                System.out.println("DIAGONAL WIN");

                return true;
            }

            //row or column check
            for(int i  = 0; i < board.length; i++) {
                if (  board[i][0] != 0 && board[i][0]  == board[i][1] &&  board[i][1] == board[i][2]) {
                    //straight win
                    System.out.println("ROW WIN");

                    return true;
                }
            }

            for(int j  = 0; j < board.length; j++) {
                if (  board[0][j] != 0  && board[0][j]  == board[1][j] &&  board[1][j] == board[2][j]) {
                    //straight win
                    System.out.println("COL WIN");
                    return true;
                }
            }


            boolean hasZero = false;
            for(int i  = 0; i < board.length; i++) {
                for(int j  = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) {
                        hasZero = true;
                    }
                }
                System.out.println();
            }

            if(hasZero == false){
                //tie has been detected
                System.out.println("TIE DETECTED");
                return true;
            }

            return false;
        }


        public static void TicTacToeGame() {

            int[][] board =  createBoard();
            printBoard(board);
            boolean result = false;
            int  user = 1;

            while(!result){

                //user 1 prompt
                //get coordinates from user
                Scanner scanner = new Scanner(System.in);
                System.out.print("User " +  user  +  " START: ");
                System.out.print("Enter your first coordinate: [0,2]");
                String row = scanner.next();
                System.out.print("Enter your Second coordinate: [0,2]");
                String col = scanner.next();
                int rowCoordinate = Integer.parseInt(row);
                int colCoordinate = Integer.parseInt(col);
                System.out.println("You selected row: " + rowCoordinate + ", col: " + colCoordinate);

                // place piece
                if (board[rowCoordinate][colCoordinate] != 0){
                    System.out.println("There is a piece here - cannot put - LOSE YOUR TURN");
                    //restart game properly for user
                } else{
                    board[rowCoordinate][colCoordinate] = user;
                }
                printBoard(board);
                result =  boardResultCheck(board);


                if(user == 1){
                    user = 2;
                }
                else{
                    user = 1;
                }
            }
        }

}
