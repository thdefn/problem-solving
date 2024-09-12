package hanghae.main.day13;

import java.util.Scanner;
// 17928 224
public class 파도반수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            long[] memo = new long[N + 1];
            System.out.println(padoban(N, memo));
        }
    }

    static long padoban(int N, long[] memo) {
        if (N <= 3)
            return 1;
        else if (N <= 5)
            return 2;

        if (memo[N] > 0)
            return memo[N];

        memo[N] = padoban(N - 1, memo) + padoban(N - 5, memo);
        return memo[N];
    }

}
