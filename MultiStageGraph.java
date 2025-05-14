public class MultistageGraph {
    public static void main(String[] args) {
        // Graph as adjacency matrix
        // 8 nodes (0 to 7), 0 is source, 7 is destination
        int[][] graph = {
            //0  1  2  3  4  5  6  7
            { 0, 2, 1, 3, 0, 0, 0, 0 }, // Node 0
            { 0, 0, 0, 0, 2, 3, 0, 0 }, // Node 1
            { 0, 0, 0, 0, 6, 7, 0, 0 }, // Node 2
            { 0, 0, 0, 0, 6, 8, 0, 0 }, // Node 3
            { 0, 0, 0, 0, 0, 0, 6, 4 }, // Node 4
            { 0, 0, 0, 0, 0, 0, 3, 5 }, // Node 5
            { 0, 0, 0, 0, 0, 0, 0, 2 }, // Node 6
            { 0, 0, 0, 0, 0, 0, 0, 0 }  // Node 7
        };

        int n = 8; // Number of nodes
        int[] cost = new int[n];
        int[] path = new int[n];

        // Initialize cost for destination node
        cost[n - 1] = 0;

        // Compute costs from second last node to source
        for (int i = n - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] != 0 && graph[i][j] + cost[j] < min) {
                    min = graph[i][j] + cost[j];
                    path[i] = j;
                }
            }
            cost[i] = min;
        }

        // Output the minimum cost
        System.out.println("Minimum cost from node 0 to " + (n - 1) + " is: " + cost[0]);

        // Output the path
        System.out.print("Path: 0");
        int i = 0;
        while (i != n - 1) {
            System.out.print(" -> " + path[i]);
            i = path[i];
        }
    }
}
