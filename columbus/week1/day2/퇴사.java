package columbus.week1.day2;

import java.util.Scanner;

public class 퇴사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        // 1. dfs 방식으로 profit 을 최대화 할 수 있는 모든 경우의 수를 살핀다.
        System.out.println(dfs(T, P, 0, 0));


    }

    static int dfs(int[] T, int[] P, int index, int totalProfit) {
        int maxProfit = totalProfit;
        for (int i = index; i < T.length; i++) {
            // 1. 재직 기간 내에 상담을 할 수 없다면, skip
            if (i + T[i] > T.length) continue;
            // 2. 재직 기간 내에 상담을 할 수 있다면
            maxProfit = Math.max(dfs(T, P, i + T[i], totalProfit + P[i]), maxProfit);
        }

        return maxProfit;
    }
}
