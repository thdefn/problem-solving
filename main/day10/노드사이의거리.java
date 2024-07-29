package main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 노드사이의거리 {
    static List<Map<Integer, Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashMap<>());
        }
        while (N-- > 1) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(u - 1).put(v - 1, dist);
            graph.get(v - 1).put(u - 1, dist);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start - 1, dest - 1));
        }
    }

    static int bfs(int start, int destination) {
        boolean[] visited = new boolean[graph.size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0}); // 노드 인덱스, 거리
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[0] == destination)
                return node[1];
            for (int neighbor : graph.get(node[0]).keySet()) {
                if (visited[neighbor]) continue;
                queue.add(new int[]{neighbor, node[1] + graph.get(node[0]).get(neighbor)});
                visited[neighbor] = true;
            }
        }
        return Integer.MAX_VALUE;
    }
}
