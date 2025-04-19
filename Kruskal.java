import java.util.*;

class Kruskal {
    // Find function
    static int find(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    // Union function
    static void union(int[] parent, int srcRoot, int destRoot) {
        parent[srcRoot] = destRoot;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int n = sc.nextInt();

        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

        int[][] graph = new int[e][3];

        System.out.println("Enter source, destination, and weight of each edge:");
        for (int i = 0; i < e; i++) {
            graph[i][0] = sc.nextInt(); // source
            graph[i][1] = sc.nextInt(); // destination
            graph[i][2] = sc.nextInt(); // weight
        }

        // Bubble sort edges by weight
        for (int i = 0; i < e - 1; i++) {
            for (int j = 0; j < e - i - 1; j++) {
                if (graph[j][2] > graph[j + 1][2]) {
                    // Swap entire rows
                    int[] temp = graph[j];
                    graph[j] = graph[j + 1];
                    graph[j + 1] = temp;
                }
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // initially all are their own parent
        }

        int total = 0;
        int count = 0;

        System.out.println("MST is:");
        for (int i = 0; i < e && count < n - 1; i++) {
            int src = graph[i][0];
            int des = graph[i][1];
            int weight = graph[i][2];

            int srcRoot = find(parent, src);
            int destRoot = find(parent, des);

            if (srcRoot != destRoot) {
                System.out.println("Edge: " + src + " - " + des + " | Weight: " + weight);
                total += weight;
                union(parent, srcRoot, destRoot);
                count++;
            }
        }

        System.out.println("Total weight of MST is: " + total);
    }
}
