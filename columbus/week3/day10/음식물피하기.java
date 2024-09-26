package columbus.week3.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 음식물피하기 {
    static int[][] drdc = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] hasTrash = new boolean[N][M];

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            hasTrash[r][c] = true;
        }


        boolean[][] visited = new boolean[N][M];
        int maxTrashSize = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (hasTrash[i][j] && !visited[i][j])
                    maxTrashSize = Math.max(maxTrashSize, dfs(hasTrash, visited, i, j));

            }
        }

        System.out.println(maxTrashSize);
    }


    static int dfs(boolean[][] hasTrash, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int count = 1;

        for (int[] d : drdc) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;

            if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0)
                continue;
            if (hasTrash[nextR][nextC] && !visited[nextR][nextC])
                count += dfs(hasTrash, visited, nextR, nextC);
        }

        return count;
    }
}
