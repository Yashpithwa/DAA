import java.util.Scanner;

class MatrixChainMultiplication {
    // Method to calculate the minimum number of multiplications
    public int matrixFind(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Initialize dp[i][i] = 0, as multiplying one matrix has no cost
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Loop over chain lengths (L = 2 to n-1)
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try all possible places to split the chain at k
                for (int k = i; k < j; k++) {
                    // Calculate cost of multiplying matrices from i to j
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        // Return the minimum cost for multiplying matrices from 1 to n-1
        return dp[1][n - 1];
    }

    public static void main(String args[]) {
        // Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Input number of matrices
        System.out.println("Enter number of matrices: ");
        int n = sc.nextInt();

        // Input the dimensions of matrices
        System.out.println("Enter dimensions (e.g., 10 20 30 for matrices 10x20 and 20x30): ");
        int[] dim = new int[n + 1]; // n+1 because we have n+1 dimensions for n matrices
        for (int i = 0; i < n + 1; i++) {
            dim[i] = sc.nextInt();
        }

        // Create an object of Multi class and call the matrixFind method
     MatrixChainMultiplication obj = new MatrixChainMultiplication();
        int result = obj.matrixFind(dim);

        // Output the result
        System.out.println("Minimum number of multiplications is: " + result);

        // Close the scanner object
        sc.close();
    }
}