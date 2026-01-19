package Tic_tac_toe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();
        ValidateMoves validator = new ValidateMoves();

        System.out.println("Welcome to Tic Tac Toe");
        System.out.print("Do you want to play the game? (yes/no): ");
        String choice = sc.next();

        if (!choice.equalsIgnoreCase("yes")) {
            System.out.println("Game exited!");
            return;
        }

        char currentPlayer = 'X';

        while (true) {
            gameBoard.printBoard();
            System.out.println("Player " + currentPlayer + " turn");
            System.out.println("Enter row andcolumn ");
            System.out.println("Row value");
            int row = sc.nextInt();
            System.out.println("Enter column value");
            int col = sc.nextInt();

            boolean NotvalidMove = gameBoard.MoveNotvalid(row,col, currentPlayer);

            if (NotvalidMove) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (validator.checkWinner(gameBoard.getBoard())) {
                gameBoard.printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (validator.isBoardFull(gameBoard.getBoard())) {
                gameBoard.printBoard();
                System.out.println("Game Draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}
