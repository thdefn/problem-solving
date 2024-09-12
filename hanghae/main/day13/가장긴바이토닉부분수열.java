package hanghae.main.day13;

import java.util.Scanner;

/**
 * 21252 312
 */
public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        if (N == 1) {
            System.out.println("1");
            return;
        }

        // 1. Sk 의 왼쪽 값의 길이 체크
        int[][] dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j])
                    dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
            }
        }

        // 2. Sk 의 오른쪽 값의 길이 체크
        for (int i = N - 1; i >= 0; i--) {
            dp[i][1] = 1;
            for (int j = N - 1; j > i; j--) {
                if (numbers[i] > numbers[j])
                    dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1);
            }
        }

        // 3. Sk 의 왼쪽값과 오른쪽 값을 합한 길이 확인
        // 이때 Sk 가 두번 카운팅 되었으므로 한번 빼줌
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(dp[i][0] + dp[i][1] - 1, maxLength);
        }
        System.out.println(maxLength);

    }
}
