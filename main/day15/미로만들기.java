package main.day15;

import java.util.*;

public class 미로만들기 {
    static int[][] drDc = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] room = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] ch = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                room[i][j] = ch[j] - '0';
            }
        }
        List<List<int[]>> edges = new ArrayList<>(); // idx, weight

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges.add(new ArrayList<>());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curIdx = flattenIndex(i, j, n);
                for (int[] ac : drDc) {
                    int r = ac[0] + i;
                    int c = ac[1] + j;
                    // 인덱스 범위 체크
                    if (r >= n || c >= n || r < 0 || c < 0)
                        continue;
                    int toIdx = flattenIndex(r, c, n);
                    edges.get(curIdx).add(new int[]{toIdx, 1 - room[r][c]});
                }
            }
        }

        int cnt = dijkstra(edges);
        System.out.println(cnt);
    }

    static int dijkstra(List<List<int[]>> edges) {
        // idx, weight 순 -> weight 순으로 솔팅한다
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // start = 0 , end = edges.size() - 1
        int[] dist = new int[edges.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new int[]{0, 0});
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
