public class FloydWarshall {

    static final int INF = 99999; // Infinity value for unreachable paths

    public static void main(String[] args) {

        // Step 1: Create a graph (adjacency matrix)
        // graph[i][j] = distance from i to j
        int[][] graph = {
            { 0,   3,   INF, 5 },
            { 2,   0,   INF, 4 },
            { INF, 1,   0,   INF },
            { INF, INF, 2,   0 }
        };

        int n = graph.length; // number of vertices

        // Step 2: Create distance matrix (copy of graph)
        int[][] dist = new int[n][n];

        // Copy values from graph to dist
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Step 3: Apply Floyd Warshall Algorithm
        // Try each vertex as intermediate point
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // If vertex k is on the shortest path from i to j,
                    // then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 4: Print the result
        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
