package columbus.week3.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {
    static int[][] drdcdh = new int[][]{
            {1, 0, 0}, {-1, 0, 0},
            {0, 1, 0}, {0, -1, 0},
            {0, 0, 1}, {0, 0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(bfs(tomato, M, N, H));
    }


    static int bfs(int[][][] tomato, int M, int N, int H) {
        int unripeCount = 0;
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();


        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tomato[k][i][j] == 0)
                        unripeCount++;
                    else if (tomato[k][i][j] == 1) {
                        q.add(new int[]{i, j, k});
                        visited.add(i + " " + j + " " + k);
                    }
                }
            }
        }

        if (unripeCount == 0)
            return 0;

        int day = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = q.remove();
                int r = cur[0];
                int c = cur[1];
                int h = cur[2];

                for (int[] d : drdcdh) {
                    int nextR = d[0] + r;
                    int nextC = d[1] + c;
                    int nextH = d[2] + h;

                    if (nextR >= N || nextR < 0 || nextC >= M || nextC < 0 || nextH >= H || nextH < 0)
                        continue;
                    if (tomato[nextH][nextR][nextC] == 0 && !visited.contains(nextR + " " + nextC + " " + nextH)) {
                        unripeCount--;
                        q.add(new int[]{nextR, nextC, nextH});
                        visited.add(nextR + " " + nextC + " " + nextH);
                    }
                }
            }
            day++;
        }


        if (unripeCount > 0)
            return -1;
        return day;
    }

}
