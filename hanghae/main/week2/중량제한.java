package hanghae.main.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 중량제한 {

    static List<Map<Integer, Integer>> graph;
    static TreeSet<Integer> minDistance;

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
            int max = Math.max(graph.get(a - 1).getOrDefault(b - 1, 0), c);
            graph.get(a - 1).put(b - 1, max);
            max = Math.max(graph.get(b - 1).getOrDefault(a - 1, 0), c);
            graph.get(b - 1).put(a - 1, max);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int islandA = Integer.parseInt(st.nextToken());
        int islandB = Integer.parseInt(st.nextToken());
        minDistance = new TreeSet<>(Collections.reverseOrder());
        boolean[] visited = new boolean[N];
        dfs(islandA - 1, islandB - 1, Integer.MAX_VALUE, visited);
        System.out.println(minDistance.first());
    }

    static void dfs(int i, int dest, int minKilo, boolean[] visited) {
        if (i == dest) {
            minDistance.add(minKilo);
            return;
        }

        visited[i] = true;
        for (int neighbor : graph.get(i).keySet()) {
            if (visited[neighbor]) continue;
            int min = Math.min(minKilo, graph.get(i).get(neighbor));
            dfs(neighbor, dest, min, visited);
        }

    }
}
