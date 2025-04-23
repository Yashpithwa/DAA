import java.util.*;

class Queens {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queens:");
        int n = sc.nextInt();
        char board[][] = new char[n][n];

        // Initialize board with '.'
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0, n);
    }

    public static void solve(char board[][], int row, int n) {
        if(row == n) {
            // Print board
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isSafe(board, row, col, n)) {
                board[row][col] = 'Q';  // Place queen
                solve(board, row + 1, n); // Recurse
                board[row][col] = '.';  // Backtrack
            }
        }
    }

    public static boolean isSafe(char board[][], int row, int col, int n) {
        // Check column
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') return false;
        }

        // Check left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        // Check right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}
