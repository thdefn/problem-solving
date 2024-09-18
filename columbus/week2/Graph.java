package columbus.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][]{
                {1, 2}, {2, 6}, {2, 4}, {4, 3}, {3, 2}, {3, 5}
        };

        toAdjacencyMatrix(n, edges);
        System.out.println();
        toAdjacencyList(n, edges);
    }

    static void toAdjacencyMatrix(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            int a = edge[0] - 1;
            int b = edge[1] - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }

    static void toAdjacencyList(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }


        for (int i = 1; i <= n; i++) {
            System.out.println(i + ": " + graph[i]);
        }
    }
}
