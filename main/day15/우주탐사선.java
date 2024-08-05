package main.day15;

import java.util.*;

// 15 30 21
//
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

    static int MST(int[][] graph, int K) {
        Queue<int[]> dist = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Set<Integer> tree = new HashSet<>();

        // 1. 임의의 정점으로 0 선택
        tree.add(K);
        for (int i = 0; i < graph.length; i++) {
            if (graph[K][i] > 0) dist.add(new int[]{graph[K][i], i});
            else dist.add(new int[]{Integer.MAX_VALUE, i});
        }

        // 2. 트리의 사이즈가 N 이 될 때까지 최소 간선 찾고, 간선 업데이트 반복
        int minCost = 0;
        while (tree.size() < graph.length) {
            int[] selected = dist.poll(); // 거리, 인덱스
            int selectedIdx = selected[1];
            tree.add(selectedIdx);
            int k = dist.size();
            minCost += selected[0];
            // 2. 간선 업데이트
            Queue<int[]> updated = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
            while (k-- > 0) {
                int[] n = dist.poll();
                int nodeIdx = n[1];
                if (graph[selectedIdx][nodeIdx] > 0)
                    n[0] = Math.min(n[0], graph[selectedIdx][nodeIdx]);
                updated.add(n);
            }
            dist = updated;
        }
        return minCost;
    }


}
