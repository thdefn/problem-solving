package columbus.week2.day7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] answer = bfs(N, K);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    static int[] bfs(int N, int K) {
        int[] time = new int[100001];
        int[] ways = new int[100001];
        Arrays.fill(time, -1);
        time[N] = 0;
        ways[N] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int next : new int[]{x - 1, x + 1, 2 * x}) {
                if (next < 0 || next > 100000) continue;

                // 1. 아직 방문하지 않은 경우
                if (time[next] == -1) {
                    time[next] = time[x] + 1;
                    ways[next] = ways[x];
                    q.add(next);
                }
                // 2. 동일한 시간에 도달한 경우
                else if (time[next] == time[x] + 1) {
                    ways[next] += ways[x];
                }
            }
        }

        return new int[]{time[K], ways[K]};
    }
}
