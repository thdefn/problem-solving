package columbus.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1
 * 3 3 5
 * 0 1
 * 1 0
 * 1 1
 * 2 0
 * 0 2
 */
public class 유기농배추 {
    static int[][] drdc = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] cabbage = new boolean[N][M];
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                cabbage[Y][X] = true;
            }


            boolean[][] visited = new boolean[N][M];
            int earthwormCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cabbage[i][j] && !visited[i][j]) {
                        earthwormCount++;
                        dfs(cabbage, visited, i, j);
                    }
                }
            }

            System.out.println(earthwormCount);
        }
    }

    static void dfs(boolean[][] cabbage, boolean[][] visited, int r, int c) {
        visited[r][c] = true;

        for (int[] d : drdc) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 || nextR >= cabbage.length || nextC < 0 || nextC >= cabbage[0].length)
                continue;
            if (cabbage[nextR][nextC] && !visited[nextR][nextC])
                dfs(cabbage, visited, nextR, nextC);
        }
    }
}
