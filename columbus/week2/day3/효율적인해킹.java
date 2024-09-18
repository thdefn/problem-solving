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
 * 2 -> 1 -> 2
 *
 * <p>
 * 3. 출력 : 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력
 */
public class 효율적인해킹 {
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B - 1].add(A - 1);
        }

        int[] hackCount = new int[N];
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            hackCount[i] = bfs(i);
            maxCount = Math.max(hackCount[i], maxCount);
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < N; i++) {
            if (hackCount[i] == maxCount)
                sj.add(String.valueOf((i + 1)));
        }
        System.out.println(sj);

    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        int count = 1;

        boolean[] visited = new boolean[graph.length];
        visited[node] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : graph[cur]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    count++;
                    queue.add(neighbor);
                }
            }
        }

        return count;
    }
}
