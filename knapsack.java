import java.util.*;

class Items {
    int weight, value;

    Items(int v, int w) {
        value = v;
        weight = w;
    }
}

public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of items:");
        int n = sc.nextInt();

        Items[] item = new Items[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value of item " + (i + 1));
            int v = sc.nextInt();
            System.out.println("Enter weight of item " + (i + 1));
            int w = sc.nextInt();
            item[i] = new Items(v, w);
        }

        System.out.println("Enter capacity of knapsack:");
        int capacity = sc.nextInt();

        // Sort items based on value/weight ratio (descending)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double r1 = (double)item[i].value / item[i].weight;
                double r2 = (double)item[j].value / item[j].weight;
                if (r1 < r2) {
                    Items temp = item[i];
                    item[i] = item[j];
                    item[j] = temp;
                }
            }
        }

        double totalValue = 0;

        for (int i = 0; i < n; i++) {
            if (capacity == 0) break;

            if (item[i].weight <= capacity) {
                totalValue += item[i].value;
                capacity -= item[i].weight;
            } else {
                // Take fractional part
                totalValue += item[i].value * ((double)capacity / item[i].weight);
                capacity = 0;
            }
        }

        System.out.println("Maximum paisa kama sakta hai: " + totalValue);
    }
}
