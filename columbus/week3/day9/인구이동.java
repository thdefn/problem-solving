package columbus.week3.day9;

import java.util.*;
import java.io.*;

public class 인구이동 {
    static int[][] drdc = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int L;
    static int R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] land = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean hasMoved;
        int day = -1;
        do{
            day++;
            boolean[][] visited = new boolean[N][N];
            hasMoved = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> lands = new ArrayList<>();
                        visited[i][j] = true;
                        lands.add(new int[]{i, j});
                        int[] result = dfs(land, visited, i, j, lands);

                        if (result[1] == 1) continue;

                        hasMoved = true;
                        int population = result[0] / result[1];
                        for (int[] rc : lands) {
                            int r = rc[0];
                            int c = rc[1];
                            land[r][c] = population;
                        }
                    }
                }
            }
        } while (hasMoved);


        System.out.println(day);
    }

    static int[] dfs(int[][] land, boolean[][] visited, int r, int c, List<int[]> lands) {
        int sum = land[r][c];
        int count = 1;

        for (int[] d : drdc) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;
            if (nextR >= land.length || nextC >= land.length || nextR < 0 || nextC < 0)
                continue;
            if (visited[nextR][nextC]) continue;
            int diff = Math.abs(land[r][c] - land[nextR][nextC]);
            if (diff >= L && diff <= R) {
                visited[nextR][nextC] = true;
                lands.add(new int[]{nextR, nextC});
                int[] result = dfs(land, visited, nextR, nextC, lands);
                sum += result[0];
                count += result[1];
            }
        }

        return new int[]{sum, count};
    }
}
