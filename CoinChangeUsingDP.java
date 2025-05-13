import java.util.*;

public class CoinChangeDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of coin types:");
        int n = sc.nextInt();

        int[] coins = new int[n];
        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println("Enter the amount:");
        int amount = sc.nextInt();

        int[] dp = new int[amount + 1];

        // Instead of Arrays.fill(), use a loop to initialize
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // Large number like "infinity"
        }

        dp[0] = 0; // Base case

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if (dp[amount] > amount) {
            System.out.println("Cannot form the amount using given coins.");
        } else {
            System.out.println("Minimum coins needed = " + dp[amount]);
        }

        sc.close();
    }
}
