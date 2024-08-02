package main.day13;

import java.util.Arrays;
import java.util.Scanner;
// 21296 316
public class 상자넣기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] box = new int[N];
        for (int i = 0; i < N; i++) {
            box[i] = sc.nextInt();
        }

        if (N == 1) {
            System.out.println("1");
            return;
        }
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (box[i] > box[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
