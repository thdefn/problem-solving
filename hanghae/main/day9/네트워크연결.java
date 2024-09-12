package hanghae.main.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 55956 628
// 1. 최소힙과 Set 을 이용해 프림 알고리즘 구현함
// 최소힙 -> 남아있는 간선 중 최소 비용인 수 체크
// Set -> selected 된 노드를 기록
// 2. selected 된 노드가 N 이 될 때까지 반복함
public class 네트워크연결 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a - 1][b - 1] = c;
            arr[b - 1][a - 1] = c;
        }

        System.out.println(MST(arr));
    }

    static int MST(int[][] graph) {
        Queue<int[]> dist = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        Set<Integer> tree = new HashSet<>();

        // 1. 임의의 정점으로 0 선택
        tree.add(0);
        for (int i = 1; i < graph.length; i++) {
            if (graph[0][i] > 0) dist.add(new int[]{graph[0][i], i});
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
