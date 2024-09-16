package columbus.week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 입력 :
 * N, 10,000보다 작거나 같은 자연수
 * M, 100,000보다 작거나 같은 자연수
 * A B, A가 B를 신뢰한다 / B를 해킹하면, A를 해킹할 수 있다
 * <p>
 * 3. 출력 : 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력
 */
public class 효율적인해킹 {
    static List<List<Integer>> graph;
    static Map<Integer, Set<Integer>> indexTreeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B - 1).add(A - 1);
        }


        indexTreeMap = new HashMap<>();
        int maxTreeSize = Integer.MIN_VALUE;
        Queue<Integer> pq = new PriorityQueue<>();
        // 1. 하나의 노드에 대한 자손 탐색
        for (int i = 0; i < N; i++) {
            if (indexTreeMap.containsKey(i))
                continue;

            Set<Integer> visited = new HashSet<>();
            visit(i, visited);

            if (visited.size() > maxTreeSize) {
                maxTreeSize = visited.size();
                pq.clear();
                pq.add(i + 1);
            } else if (maxTreeSize == visited.size()) {
                pq.add(i + 1);
            }
        }


        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    static void visit(int node, Set<Integer> childSet) {
        if (indexTreeMap.containsKey(node)) {
            childSet.addAll(indexTreeMap.get(node));
            return;
        }

        Set<Integer> before = new HashSet<>(childSet);
        childSet.add(node);

        for (int neighbor : graph.get(node)) {
            if (!childSet.contains(neighbor))
                visit(neighbor, childSet);
        }

        Set<Integer> after = new HashSet<>(childSet);
        after.removeAll(before);
        indexTreeMap.put(node, after);
    }
}
