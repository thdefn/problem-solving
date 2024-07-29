package main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 1. 입력 : 도시의 개수, 도로의 개수, 거리 K, 간선, 출발 도시 번호

 2. BFS 를 활용해 레벨이 k인 노드 탐색하기
 2-1. Queue 와 Set 을 활용해 BFS 를 구현함
 2-1-1. Queue 는 다음에 방문할 노드를 담고 있다
 2-1-2. Set 은 이미 방문한 노드를 담고 있다. -> 이미 방문한 노드가 아니라면 Queue 에 넣는다.
 2-1-3. K 번 탐색 후 종료
 2-2. 탐색 후 Queue 에는 K 레벨 노드가 담겨 있다

 3. 출력 : 거리가 K 인 도시의 번호를 오름차순으로 출력
 */
public class 특정거리의도시찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A - 1).add(B - 1);
        }
        Set<Integer> nodes = bfs(X - 1, graph, K);
        if(nodes.isEmpty())
            System.out.println("-1");
        else {
            for (int n : nodes){
                System.out.println(n + 1);
            }
        }
    }

    static Set<Integer> bfs(int X, List<Set<Integer>> graph, int K) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        visited.add(X);
        while (!queue.isEmpty() && K-- > 0) {
            int searchSize = queue.size();
            for (int i = 0; i < searchSize; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        if (queue.isEmpty())
            return Set.of();
        return new TreeSet<>(queue);
    }
}
