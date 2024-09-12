package hanghae.main.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회장뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            if (u == -2 && v == -2) break;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 노드 별로 다익스트라
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int score = dijkstra(graph, i);
            res.add(new int[]{score, i + 1});
        }
        // score 낮은 순, index 낮은 순 정렬
        res.sort((o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        // 결과 출력
        int bestScore = res.get(0)[0];
        StringJoiner sj = new StringJoiner(" ");
        int i = 0;
        for (i = 0; i < res.size(); i++) {
            if(bestScore < res.get(i)[0]) break;
            sj.add(String.valueOf(res.get(i)[1]));
        }
        System.out.println(bestScore + " " + i);
        System.out.println(sj);
    }

    static int dijkstra(List<List<Integer>> graph, int from) {
        // distance 낮은 순 정렬
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // from 노드 추가하기
        pq.add(new int[]{from, 0});
        dist[from] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int uDist = cur[1];
            if (uDist > dist[u]) continue;

            for (int v : graph.get(u)) {
                if (uDist + 1 < dist[v]) {
                    dist[v] = uDist + 1;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        // dist 의 max 값이 회원의 점수
        return Arrays.stream(dist).max().getAsInt();
    }
}
