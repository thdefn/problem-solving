package pre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 광물 {
    static List<List<Integer>> fatigue = List.of(
            List.of(1, 1, 1),
            List.of(5, 1, 1),
            List.of(25, 5, 1));
    static Map<String, Integer> mineIndexMap = Map.of(
            "diamond", 0, "iron", 1, "stone", 2);

    static List<int[]> mineCount = new ArrayList<>();

    public static int solution(int[] picks, String[] minerals) {

        int[] cnt = new int[3];

        for (int i = 0; i < minerals.length; i++) {
            if (i % 5 == 0 && i != 0) {
                mineCount.add(cnt);
                cnt = new int[3];
            }
            cnt[mineIndexMap.get(minerals[i])]++;
        }

        mineCount.add(cnt);

        return selectPick(picks, 0);
    }

    public static int selectPick(int[] picks, int idx) {
        if (idx == mineCount.size() || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            return 0;
        }

        int minExpense = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (picks[i] < 1) continue;

            // 이번 턴에 pick[i] 를 고른다.
            // 1. 광물을 돌며 비용 계산
            int[] cnt = mineCount.get(idx);
            int expense = 0;
            for (int j = 0; j < 3; j++) {
                expense += (fatigue.get(i).get(j) * cnt[j]);
            }

            int[] copy = picks.clone();
            copy[i]--;
            minExpense = Math.min(expense + selectPick(copy, idx + 1), minExpense);
        }

        return minExpense;
    }


    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }

}
