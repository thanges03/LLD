
package Tic_tac_toe;
public class GameBoard {
    static char[][] board = new char[3][3];

    public GameBoard() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = ' '; 
        }
    }
}

public void printBoard() {
    System.out.println("\nBoard:");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            System.out.print(" " + board[i][j] + " ");
            if (j < 2) System.out.print("|");
        }
        for (int j = 0; j < 3; j++) {
            System.out.print(i+" " +j+ " ");
            if (j < 2) System.out.print("|");
        }
        System.out.println();
        if (i < 2) System.out.println("---+---+---");
    }
}

   
    public boolean MoveNotvalid(int row, int col,char currentPlayer) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 )
            return true;

        if(board[row][col] !=' ')
            return true;
        board[row][col] = currentPlayer;
        return false;
    }

    public char[][] getBoard() {
    return board;
}

}
