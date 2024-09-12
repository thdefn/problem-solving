package hanghae.main.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 택배배송 {
    static class Edge {
        int weight;
        int target;

        Edge(int target, int weight) {
            this.weight = weight;
            this.target = target;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());
            edges.get(A).add(new Edge(B, C));
            edges.get(B).add(new Edge(A, C));
        }

        System.out.println(dijkstra(edges, 0, N - 1));
    }

    static int dijkstra(List<List<Edge>> edges, int from, int to) {
        // 가장 최소 비용 간선을 선택하기 위한 우선순위큐
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        // 최소 거리 갱신할 distance 배열 만들기
        int[] distance = new int[edges.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // from 노드의 distance 는 0으로 만든다.
        pq.add(new Edge(from, 0));
        distance[from] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int u = cur.target;
            int uWeight = cur.weight;
            if (uWeight > distance[u]) continue;
            // 노드의 이웃 간선 탐색
            for (Edge e : edges.get(u)) {
                int v = e.target;
                int vWeight = e.weight;
                // start 노드를 거치는 길이 현재까지 최소 비용이면
                if (distance[u] + vWeight < distance[v]) {
                    distance[v] = distance[u] + vWeight;
                    pq.add(new Edge(v, distance[v]));
                }
            }
        }
        return distance[to];
    }

}
