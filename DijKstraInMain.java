public class DijkstraInMain {
    public static void main(String[] args) {
        int V = 6; // Number of vertices

        int[][] graph = {
            // 0  1  2  3  4  5
            { 0, 4, 0, 0, 0, 0 }, // 0
            { 4, 0, 8, 0, 0, 0 }, // 1
            { 0, 8, 0, 7, 0, 4 }, // 2
            { 0, 0, 7, 0, 9, 14 },// 3
            { 0, 0, 0, 9, 0, 10 },// 4
            { 0, 0, 4, 14, 10, 0 } // 5
        };

        int[] dist = new int[V];       // Output array
        boolean[] visited = new boolean[V]; // Visited set

        // Step 1: Initialize all distances to infinity and visited to false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        int src = 0; // Start from node 0
        dist[src] = 0;

        // Step 2: Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            int min = Integer.MAX_VALUE;

            // Find the unvisited node with the minimum distance
            for (int i = 0; i < V; i++) {
                if (!visited[i] && dist[i] <= min) {
                    min = dist[i];
                    u = i;
                }
            }

            visited[u] = true;

            // Step 3: Update distances of adjacent nodes
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Step 4: Print shortest distances
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
