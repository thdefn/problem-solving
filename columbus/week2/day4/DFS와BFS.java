package columbus.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graph = new boolean[N][N];

        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A - 1][B - 1] = true;
            graph[B - 1][A - 1] = true;
        }

        dfs(V - 1, new boolean[N]);
        System.out.println();
        bfs(V - 1);

    }

    static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print((node + 1) + " ");

        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    static void bfs(int node) {
        boolean[] visited = new boolean[graph.length];
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print((cur + 1) + " ");

            for (int i = 0; i < graph.length; i++) {
                if (graph[cur][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
