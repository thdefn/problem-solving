package columbus.week2.day6;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] drdc = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[][] miro;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new char[N][M];
        for (int i = 0; i < N; i++) {
            miro[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs());
    }

    static int bfs() {
        int[][] distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], -1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        distance[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];

            for (int[] d : drdc) {
                int nextR = d[0] + i;
                int nextC = d[1] + j;

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
                    continue;

                if (miro[nextR][nextC] == '1' && distance[nextR][nextC] == -1) {
                    distance[nextR][nextC] = distance[i][j] + 1;
                    q.add(new int[]{nextR, nextC});
                }
            }

        }
        return distance[N - 1][M - 1];
    }

    static int dfs(int r, int c, boolean[][] visited, int step) {
        if (r == N - 1 && c == M - 1)
            return step;
        int minStep = Integer.MAX_VALUE;
        for (int[] d : drdc) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR >= N || nextC >= M || nextR < 0 || nextC < 0)
                continue;
            if (minStep <= step) continue;
            if (miro[nextR][nextC] == '1' && !visited[nextR][nextC]) {
                visited[nextR][nextC] = true;
                minStep = Math.min(dfs(nextR, nextC, visited, step + 1), minStep);
                visited[nextR][nextC] = false;
            }
        }
        return minStep;
    }


}
