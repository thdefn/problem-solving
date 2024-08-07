package topic.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 수고르기 {
    public static void main(String[] args) {
        // 1. 입력을 받는다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);


        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= i; j--) {
                // 차이가 M 보다 작으면 더 이상 i 에서 볼 필요 없다.
                if (A[j] - A[i] < M) break;
                minDiff = Math.min(minDiff, A[j] - A[i]);
            }
            if (minDiff == M) break;
        }

        System.out.println(minDiff);
    }
}
