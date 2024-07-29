package main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1. 입력 : 상자의 가로 칸 수, 상자의 세로 칸 수, 상자의 수, 하나의 상자의 토마토 상태
 * <p>
 * 2. bfs 을 사용함
 * <p>
 * 3. 출력 : 토마토가 모두 익는 최소 날짜, 토마토가 모두 익지 못하면 -1
 */
public class 토마토 {
    static int[][] dhdrdc = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken()); // C
        int N = Integer.parseInt(st.nextToken()); // R
        int H = Integer.parseInt(st.nextToken());
        int[][][] box = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(bfs(box, H, N, M));

    }

    static int bfs(int[][][] box, int H, int R, int C) {
        Set<String> riped = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>(); // h, r, c

        int tomatoCount = R * C * H;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (box[h][i][j] == -1) tomatoCount--;
                    if (box[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j});
                        riped.add(h + " " + i + " " + j);
                    }
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty() && riped.size() < tomatoCount) {
            day++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll();
                for (int[] hrc : dhdrdc) {
                    int h = tomato[0] + hrc[0];
                    int r = tomato[1] + hrc[1];
                    int c = tomato[2] + hrc[2];
                    if (h >= H || h < 0 || r >= R || r < 0 || c >= C || c < 0)
                        continue;
                    if (box[h][r][c] == 0 && !riped.contains(h + " " + r + " " + c)) {
                        queue.add(new int[]{h, r, c});
                        riped.add(h + " " + r + " " + c);
                    }
                }
            }
        }

        if (riped.size() == tomatoCount)
            return day;
        return -1;
    }

}
