package main.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 90440 632
public class 로봇조종하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] value = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][M];
        dp[0][0] = value[0][0];
        // 1. 첫번째 행은 왼쪽 -> 오른쪽으로만 이동함
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + value[0][i];
        }

        // 2. 두번째 행부터는 왼쪽, 오른쪽, 위에서 오는 경우 고려
        for (int i = 1; i < N; i++) {
            // 1. 왼쪽에서 오른쪽으로 향할때의 경로
            int[] left = new int[M];
            // 이때 가장 첫번째 열의 경우, 위에서 오는 방향만 고려
            left[0] = dp[i - 1][0] + value[i][0];
            for (int j = 1; j < M; j++) {
                // 위에서 오는 방향과 왼쪽에서 오는 방향 고려한다
                left[j] = Math.max(dp[i - 1][j], left[j - 1]) + value[i][j];
            }


            // 2. 오른쪽에서 왼쪽으로 향할때의 경로
            int[] right = new int[M];
            // 이때 가장 마지막 열의 경우, 위에서 오는 방향만 고려
            right[M - 1] = dp[i - 1][M - 1] + value[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                // 위에서 오는 방향과 오른쪽에서 오는 방향 고려한다
                right[j] = Math.max(dp[i - 1][j], right[j + 1]) + value[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);

    }


}
