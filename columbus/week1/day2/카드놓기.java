package columbus.week1.day2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 1. 입력 : 첫째 줄에 n, 둘째 줄에 k, 셋째줄부터  n개 줄 카드에 적혀있는 수
 * <p>
 * 2.
 * 3. 출력
 */
public class 카드놓기 {
    static int k;
    static Set<Integer> numberSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        dfs(cards, new boolean[n], 0, "");


        System.out.println(numberSet.size());
    }

    static void dfs(int[] cards, boolean[] selected, int depth, String number) {
        if (depth == k) {
            numberSet.add(Integer.parseInt(number));
            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (selected[i])
                continue;
            selected[i] = true;
            dfs(cards, selected, depth + 1, number + cards[i]);
            selected[i] = false;
        }
    }
}
