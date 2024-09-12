package hanghae.main.day13;

import java.util.Arrays;
import java.util.Scanner;
// 21360 296
public class 가장큰증가하는부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = numbers[i];
            for (int j = 0; j < i; j++) {
                if(numbers[i] > numbers[j]){
                    dp[i] = Math.max(dp[j] + numbers[i], dp[i]);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
