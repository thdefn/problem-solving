package columbus.week3.day9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기 {
    static int[][] drdc = new int[][]{
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }


        System.out.println(bfs(map));

    }

    static int bfs(char[][] map) {
        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        dist[0][0] = 1;


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] d : drdc) {
                int nextR = d[0] + r;
                int nextC = d[1] + c;
                if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0)
                    continue;
                // 2. 벽이 있는 곳이라면, 벽을 뚫고 갈 수 있는지 체크
                int chanceUsed = cur[2];
                if (map[nextR][nextC] == '1' && chanceUsed == 0)
                    chanceUsed = 1;
                    // 2-2. 벽을 뚫고 못간다면 이 way 는 종료
                else if (map[nextR][nextC] == '1')
                    continue;

                // 3. 큐에 집어 넣는다.

                if (dist[nextR][nextC] == -1) {
                    dist[nextR][nextC] = dist[r][c] + 1;
                    q.add(new int[]{nextR, nextC, chanceUsed});
                } else if (dist[nextR][nextC] > dist[r][c] + 1) {
                    dist[nextR][nextC] = dist[r][c] + 1;
                    q.add(new int[]{nextR, nextC, chanceUsed});
                }
            }
        }


        return dist[N - 1][M - 1];
    }


    static int dfs(char[][] map, boolean[][] visited, int r, int c, boolean hasChance, int distance) {
        if (r == N - 1 && c == M - 1)
            return distance;
        if (map[r][c] == '1' && hasChance)
            hasChance = false;
        else if (map[r][c] == '1' && !hasChance) return Integer.MAX_VALUE;


        int minDistance = Integer.MAX_VALUE;
        for (int[] d : drdc) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0)
                continue;
            if (!visited[r][c]) {
                visited[r][c] = true;
                minDistance = Math.min(dfs(map, visited, nextR, nextC, hasChance, distance + 1), minDistance);
                visited[r][c] = false;
            }
        }

        return minDistance;
    }
}
