package topic.투포인터;

import java.util.Scanner;

public class 수들의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int sum = A[0];
        int count = 0;
        while (j < A.length - 1) {
            if (sum == M) count++;

            if (sum < M) {
                j++;
                sum += A[j];
            } else { // sum >= M
                sum -= A[i];
                i++;
            }
        }

        // j 가 A 범위를 넘어섰다면, sum > M 인 경우를 체크해야 함
        // i 를 증가시킨다.
        while (i <= A.length - 1 && sum > M) {
            sum -= A[i];
            i++;
        }
        if (sum == M) count++;

        System.out.println(count);
    }
}
