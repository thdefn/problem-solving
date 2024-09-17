package columbus.week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int[][] drdc = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomatoes = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 1. 익어야 하는 토마토 개수 체크
        // 2. 익은 토마토 조사
        int unripeTomatoCount = 0;
        Queue<int[]> riped = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0)
                    unripeTomatoCount++;
                else if (tomatoes[i][j] == 1)
                    riped.add(new int[]{i, j});
            }
        }

        System.out.println(bfs(riped, tomatoes, unripeTomatoCount));


    }


    static int bfs(Queue<int[]> riped, int[][] tomatoes, int unripeTomatoCount) {
        int day = -1;
        while (!riped.isEmpty()) {
            day++;
            int countOfRipedTomato = riped.size();
            for (int i = 0; i < countOfRipedTomato; i++) {
                int[] tomato = riped.poll();
                for (int[] d : drdc) {
                    int nextR = d[0] + tomato[0];
                    int nextC = d[1] + tomato[1];
                    if (nextR < 0 || nextR >= tomatoes.length || nextC < 0 || nextC >= tomatoes[0].length)
                        continue;
                    if (tomatoes[nextR][nextC] == 0) {
                        tomatoes[nextR][nextC] = 1;
                        riped.add(new int[]{nextR, nextC});
                        unripeTomatoCount--;
                    }
                }
            }
        }

        if (unripeTomatoCount > 0)
            return -1;
        return day;
    }
}
