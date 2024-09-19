package columbus.week2.day6;

import java.io.*;
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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(dfs(0, 0, new boolean[N][M], 1));
        bw.flush();
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
