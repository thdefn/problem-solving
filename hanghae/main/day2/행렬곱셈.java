package hanghae.main.day2;

import java.util.Scanner;

public class 행렬곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 1. input 행렬 A 를 받는다
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 2. input 행렬 B 를 받는다
        M = sc.nextInt();
        int K = sc.nextInt();
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < K; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // 3. 행렬 곱셈 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                // 3-1. A의 i행 * B의 j열 연산 ex) 1행 1열 : A의 1행 * B 의 1열
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += A[i][k] * B[k][j];
                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }

    }
}
