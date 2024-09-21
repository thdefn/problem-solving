package columbus.week2.day7;

import java.io.*;
import java.util.*;

public class 쉬운최단거리 {
    static int[][] drdc = new int[][]{
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minDistance = new int[n][m];
        bfs(map, minDistance);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(minDistance[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();

    }

    static void bfs(int[][] map, int[][] minDistance) {
        Queue<int[]> q = new LinkedList<>();

        // 1. 목표 지점을 찾는다.
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                    minDistance[i][j] = 0;
                } else if(map[i][j] == 0){
                    minDistance[i][j] = 0;
                } else {
                    minDistance[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];

            for (int[] d : drdc) {
                int nextR = r + d[0];
                int nextC = c + d[1];
                if (nextR >= map.length || nextR < 0 || nextC >= map[0].length || nextC < 0)
                    continue;
                if (map[nextR][nextC] == 1 && minDistance[nextR][nextC] == -1) {
                    minDistance[nextR][nextC] = minDistance[r][c] + 1;
                    q.add(new int[]{nextR, nextC});
                }
            }
        }

    }
}
