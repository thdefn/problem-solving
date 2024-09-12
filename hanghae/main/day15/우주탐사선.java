package hanghae.main.day15;

import java.util.*;

public class 우주탐사선 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }


        System.out.println(MST(graph, K));
    }



    //- 임의의 시작 정점을 선택한다
    //- 현재의 트리에서 연결된 간선 중 최소 가중치 간선의 정점을 선택하여 트리에 추가
    //- 새로 연결된 정점에서 다시 최소 가중치 간선의 정점을 선택하여 추가

    static int MST(int[][] graph, int K) {
        // 노드의 집합 U 를 K 로 시작함
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Set<Integer> U = new HashSet<>();
        pq.add(new int[]{K, 0}); // target, weight

        int minimumDistance = 0;
        while (U.size() < graph.length) {
            int[] cur = pq.poll();
            int u = cur[0];
            int uDist = cur[1];
            if (U.contains(u)) continue;
            System.out.println(u + " " + uDist);
            minimumDistance += uDist;
            U.add(u);
            for (int i = 0; i < graph.length; i++) {
                if (u == i) continue;
                pq.add(new int[]{i, graph[u][i]});
            }
        }
        return minimumDistance;
    }

}
