import java.util.*;

class Prims {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix (9999 for no edge):");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        boolean[] selected = new boolean[n];
        selected[0] = true;

        int edgeCount = 0;
        int totalCost = 0;

        System.out.println("Minimum Spanning Tree is:");

        while(edgeCount < n - 1) {
            int min = 9999;
            int x = 0, y = 0;

            for(int i = 0; i < n; i++) {
                if(selected[i]) {
                    for(int j = 0; j < n; j++) {
                        if(!selected[j] && graph[i][j] < min) {
                            min = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println("Edge: " + x + " - " + y + " | Weight: " + min);
            selected[y] = true;
            totalCost += min;
            edgeCount++;
        }

        System.out.println("Total weight of MST is: " + totalCost);
    }
}
