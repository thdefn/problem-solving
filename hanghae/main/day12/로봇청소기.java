package hanghae.main.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14392	136
 * 1. 입력 :
 * 방의 크기 N M (N M)
 * 로봇청소기의 초기 좌표, 바라보는 방향 (r c d)
 * 칸의 상태 0 (청소안함) 1 (벽)
 * <p>
 * 2.
 * <p>
 * 3. 출력 : 로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수
 */
public class 로봇청소기 {
    static int[][] drDc = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력을 받는다
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 2.
        int nextR = r;
        int nextC = c;
        int nextD = d;
        int count = 0;
        while (true) {
            // 현재 칸을 청소
            if (!visited[nextR][nextC]) {
                count++;
                visited[nextR][nextC] = true;
            }

            // 주변에 청소되지 않은 칸이 있는지 확인
            boolean hasNotVisitedCoord = false;
            for (int i = 0; i < 4; i++) {
                nextD = (nextD + 3) % 4;
                int x = nextR + drDc[nextD][0];
                int y = nextC + drDc[nextD][1];
                if (x < 0 || x >= N || y < 0 || y >= M) continue;
                if (room[x][y] == 0 && !visited[x][y]) {
                    nextR = x;
                    nextC = y;
                    hasNotVisitedCoord = true;
                    break;
                }
            }

            // 주변에 청소되지 않은 칸이 없다면
            if (!hasNotVisitedCoord) {
                // 한칸 후진해보기
                int dd = (nextD + 2) % 4;
                int x = nextR + drDc[dd][0];
                int y = nextC + drDc[dd][1];
                if (x < 0 || x >= N || y < 0 || y >= M || room[x][y] == 1)
                    break;
                nextR = x;
                nextC = y;
            }
        }

        System.out.println(count);


    }
}
