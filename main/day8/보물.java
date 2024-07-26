package main.day8;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1 1 1 6 0
 * 2 7 8 3 1
 *
 * 1. B의 가장 큰 값이 A의 가장 작은 값과 곱해져야 함
 * 6 1 1 1 0
 * 1 2 3 7 8
 *
 * 2. A에 있는 수만 재배열해서 문제를 풀 수 있음
 * 1 1 0 1 6
 * 2 7 8 3 1
 */
public class 보물 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int j = 0; j < N; j++) {
            A[j] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }

        Arrays.sort(A);
        Arrays.sort(B);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ((long) A[i]) * B[N - i - 1];
        }
        System.out.println(sum);
    }
}
