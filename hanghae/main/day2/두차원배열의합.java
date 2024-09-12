package hanghae.main.day2;

import java.util.Scanner;

public class 두차원배열의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 1. input 배열을 입력받는다.
        int arr[][] = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 2. 누적합을 구한다
        int acc[][] = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                acc[i][j] = arr[i][j] + acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];
            }
        }


        // 3. 누적합을 통해 답을 구한다.
        int K = sc.nextInt();
        while (K-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(acc[x][y] - acc[x][j - 1] - acc[i - 1][y] + acc[i - 1][j - 1]);
        }

    }
}
