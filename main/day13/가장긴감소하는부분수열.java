package main.day13;

import java.util.Arrays;
import java.util.Scanner;
// 21180 244
public class 가장긴감소하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
