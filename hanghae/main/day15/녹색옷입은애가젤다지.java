package hanghae.main.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 녹색옷입은애가젤다지 {
    static int[][] drDc = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int problemCount = 0;
        while (N > 0) {
            int[][] land = new int[N][N];
            problemCount++;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            List<List<int[]>> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    edges.add(new ArrayList<>());
                    int curIdx = flattenIndex(i, j, N);
                    for (int[] d : drDc) {
                        int r = i + d[0];
                        int c = j + d[1];

                        // 인덱스 범위 체크
                        if (r >= N || c >= N || r < 0 || c < 0)
                            continue;
                        int toIdx = flattenIndex(r, c, N);
                        edges.get(curIdx).add(new int[]{toIdx, land[r][c]});
                    }
                }
            }

            System.out.println("Problem " + problemCount + ": " +  dijkstra(edges, land[0][0]));

            N = Integer.parseInt(br.readLine());
        }
    }

    static int dijkstra(List<List<int[]>> edges, int initExpense) {
        // idx, weight 순 -> weight 순으로 솔팅한다
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // start = 0 , end = edges.size() - 1
        int[] dist = new int[edges.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = initExpense;
        pq.add(new int[]{0, initExpense});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int uWeight = cur[1];
            if (uWeight > dist[u]) continue;
            // 이웃 노드 방문해서 릴렉스
            for (int[] node : edges.get(u)) {
                int v = node[0];
                int vWeight = node[1];
                if (uWeight + vWeight < dist[v]) {
                    dist[v] = uWeight + vWeight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist[edges.size() - 1];

    }

    static int flattenIndex(int i, int j, int n) {
        return i * n + j; // i =  8 / 8 , j = 8 % 8
    }
}
