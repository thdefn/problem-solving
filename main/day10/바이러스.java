package main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 1. 입력 : 컴퓨터의 수, 간선 정보

 2. DFS 를 활용해 노드 1과 연결된 그래프를 그리지
 2-1. 재귀 구조와 Set 을 활용해 DFS 를 구현함
 2-1-1. 이웃 노드의 자식 노드가 먼저 탐색되는 구조
 2-1-2. Set 은 이미 방문한 노드를 담고 있다. -> 이미 방문한 노드가 아니라면 방문한다.
 2-2. Set 에는 결과적으로 1과 연결된 노드들이 담겨 있음

 3. 출력 : 연결된 컴퓨터의 수
 */
public class 바이러스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[V][V];
        StringTokenizer st;
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A - 1][B - 1] = true;
            graph[B - 1][A - 1] = true;
        }

        Set<Integer> visitedSet = new HashSet<>();
        dfs(0, graph, visitedSet);
        System.out.println(visitedSet.size() - 1);
    }

    static void dfs(int idx, boolean[][] graph, Set<Integer> memo) {
        if (memo.contains(idx))
            return;

        memo.add(idx);
        for (int i = 0; i < graph[idx].length; i++) {
            if (graph[idx][i])
                dfs(i, graph, memo);
        }
    }
}
