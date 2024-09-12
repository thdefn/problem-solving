package hanghae.main.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 중량제한2 {
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

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int minIdx = Math.min(a, b);
            int maxIdx = Math.max(a, b);
            int max = Math.max(graph.get(minIdx - 1).getOrDefault(maxIdx - 1, 0), c);
            graph.get(minIdx - 1).put(maxIdx - 1, max);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int islandA = Integer.parseInt(st.nextToken());
        int islandB = Integer.parseInt(st.nextToken());
        int minIdx = Math.min(islandA, islandB);
        int maxIdx = Math.max(islandA, islandB);
        System.out.println(bfs(minIdx - 1, maxIdx - 1));
    }

    static int bfs(int start, int dest) {
        Queue<int[]> queue = new LinkedList<>();
        for (int node : graph.get(start).keySet()) {
            queue.add(new int[]{node, graph.get(start).get(node)});
        }

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int[] n = queue.poll();
            int node = n[0];
            int dist = n[1];
            if (node == dest) {
                max = Math.max(dist, max);
                continue;
            }
            for (int neighbor : graph.get(node).keySet()) {
                queue.add(new int[]{neighbor, Math.min(graph.get(start).get(neighbor), dist)});
            }
        }
        return max;
    }
}
