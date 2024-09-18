package columbus.week2.day5;

import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        int edgeSize = N - 1;
        StringTokenizer st;
        while (edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a - 1].add(b - 1);
            graph[b - 1].add(a - 1);
        }

        int[] parents = new int[N];
        bfs(parents);

        for (int i = 1; i < N; i++) {
            System.out.println((parents[i] + 1));
        }

    }

    static void bfs(int[] parents) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Arrays.fill(parents, -1);
        parents[0] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph[node]) {
                if (parents[neighbor] == -1) {
                    q.add(neighbor);
                    parents[neighbor] = node;
                }
            }
        }
    }
}
