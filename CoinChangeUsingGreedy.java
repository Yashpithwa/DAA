import java.util.*;

public class CoinChangeGreedy {
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

        Arrays.sort(coins); // Sort in ascending order
        int count = 0;

        System.out.print("Coins used: ");
        for (int i = n - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
                System.out.print(coins[i] + " ");
            }
        }

        if (amount == 0)
            System.out.println("\nMinimum coins (Greedy) = " + count);
        else
            System.out.println("\nCannot form the amount using greedy approach");

        sc.close();
    }
}
