package Week06;

public class TicTacToe {
	
    public static char judge(char[][] board) {
        // Check rows for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Check columns for a winner
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }

        // Check diagonals for a winner
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        // Check for draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    draw = false;
                    break;
                }
            }
        }

        return draw ? 'D' : ' '; // 'D' for draw, ' ' for ongoing game
    }

    public static void printBoard(char[][] board) {
        System.out.println("Current Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-------------");
            }
        }
    }

    public static void main(String[] args) {
    	
        char[][] board1 = {
            {'X', 'O', 'X'},
            {'O', 'X', 'O'},
            {'O', 'X', 'X'}
        };
        printBoard(board1);
        System.out.println("Result: " + judge(board1));
        System.out.println();

        char[][] board2 = {
            {'X', 'O', 'O'},
            {'O', 'X', 'X'},
            {'X', 'X', 'O'}
        };
        printBoard(board2);
        System.out.println("Result: " + judge(board2));
        System.out.println();

        char[][] board3 = {
            {'X', 'O', ' '},
            {'O', 'X', 'O'},
            {' ', ' ', 'X'}
        };
        printBoard(board3);
        System.out.println("Result: " + judge(board3));
        System.out.println();

        char[][] board4 = {
            {'O', 'O', 'O'},
            {'X', 'X', ' '},
            {' ', ' ', 'X'}
        };
        printBoard(board4);
        System.out.println("Result: " + judge(board4)); 
        System.out.println();
    }
}
