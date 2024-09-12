package hanghae.main.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 입력 : 세로 N, 가로 M 크기의 집터, B개의 블록   (N M B)
 * 집터 맨 왼쪽 위의 좌표는 (0, 0)
 * <p>
 * 2. 출력 : 땅을 고르는 데 걸리는 시간, 땅의 높이
 */
public class 마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] dust = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                dust[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int height = 0;
        int minSecond = Integer.MAX_VALUE;
        int bestHeight = 0;
        while (height <= 256) {
            long block = B;
            int second = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dust[i][j] > height) {
                        // 블록을 제거
                        second += (dust[i][j] - height) * 2;
                        // 인벤토리에 추가
                        block += (dust[i][j] - height);
                    } else if (dust[i][j] < height) {
                        // 블록을 추가
                        second += (height - dust[i][j]);
                        // 인벤토리에서 제거
                        block -= (height - dust[i][j]);
                    }
                }
            }
            // 블록이 마이너스가 아닌 경우, second 가 최소인지 체크
            if (block >= 0 && minSecond >= second) {
                minSecond = second;
                bestHeight = height;
            }
            height++;
        }

        System.out.println(minSecond + " " + bestHeight);

    }
}
