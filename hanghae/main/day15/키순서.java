package hanghae.main.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 하위 노드는 상위 노드의 최단 거리를 모두 알지 못하면 순서를 모른다
 * 2. 하위 노드는 자신과 동일한 레벨의 노드가 있으면 순서를 모른다.
 */
public class 키순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N][N];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            dist[a][b] = 1; // a 가 b 보다 작다
        }

        // 플로이드 워셜
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }

        // idx, cnt -> cnt 가 적은 순 솔팅
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);


        for (int i = 0; i < N; i++) {
            int moreCount = 0;
            for (int j = 0; j < N; j++) {
                if (dist[i][j] < INF)
                    moreCount++;
            }
            queue.add(new int[]{i, moreCount});
        }

        //  1. 하위 노드는 상위 노드의 최단 거리를 모두 알지 못하면 순서를 모른다
        //  2. 하위 노드는 자신과 동일한 레벨의 노드가 있으면 순서를 모른다.
        int answer = 0;
        Set<Integer> parent = new HashSet<>();
        while (!queue.isEmpty()) {
            int moreCount = queue.peek()[1];

            // 1. 자식과 동일한 레벨의 노드가 몇개인지 체크한다. 상위 노드일수록 최단 거리를 아는 노드가 적어진다.
            int sameLevel = 0;
            int[] node;
            while (!queue.isEmpty() && moreCount == queue.peek()[1]) {
                node = queue.poll();
                parent.add(node[0]);
                sameLevel++;
            }


            // 1. 자신과 동일한 레벨의 노드가 있으면 순서를 모른다.
            if (sameLevel > 1)
                continue;
            // 2. 부모의 최단 거리를 모두 알아야 함
            if (parent.size() == moreCount)
                answer++;
        }

        System.out.println(answer);


    }
}
