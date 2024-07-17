package pre;

import java.util.*;

public class 이모티콘할인 {
    static Map<Integer, Set<Integer>> discountRateUserIdxMap = new HashMap<>(); // 40, [0,1]
    static List<Integer> discountRates = List.of(10, 20, 30, 40);
    static List<int[]> res = new ArrayList<>();

    public static int[] solution(int[][] users, int[] emoticons) {
        for (int discount : discountRates) {
            discountRateUserIdxMap.put(discount, new HashSet<>());
        }
        for (int i = 0; i < users.length; i++) {
            addUserToDiscountRateUserIdxMap(users[i][0], i);
        }
        dp(emoticons, users, 0, new int[users.length][emoticons.length]);
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });

        return res.get(0);
    }

    public static void dp(int[] emoticons, int[][] users, int idx, int[][] userPaid) { // 유저 인덱스 [이모티콘 구매 목록]
        if (idx == emoticons.length) {
            int emoticonPlus = 0;
            int sumOfPaid = 0;
            for (int i = 0; i < users.length; i++) {
                int sumOfUserPaid = Arrays.stream(userPaid[i]).sum();
                if (sumOfUserPaid >= users[i][1])
                    emoticonPlus++;
                else sumOfPaid += sumOfUserPaid;
            }
            res.add(new int[]{emoticonPlus, sumOfPaid});
            return;
        }

        for (int discount : discountRates) {
            int discountedPrice = emoticons[idx] - emoticons[idx] * (discount) / 100;
            int[][] next = new int[users.length][emoticons.length];
            for (int i = 0; i < userPaid.length; i++) {
                next[i] = userPaid[i].clone();
            }
            for (int userIdx : discountRateUserIdxMap.get(discount)) {
                next[userIdx][idx] += discountedPrice;
            }
            dp(emoticons, users, idx + 1, next);
        }
    }

    public static void addUserToDiscountRateUserIdxMap(int discount, int userIdx) {
        if (discount <= 10) {
            discountRateUserIdxMap.getOrDefault(10, new HashSet<>()).add(userIdx);
        }
        if (discount <= 20) {
            discountRateUserIdxMap.getOrDefault(20, new HashSet<>()).add(userIdx);
        }
        if (discount <= 30) {
            discountRateUserIdxMap.getOrDefault(30, new HashSet<>()).add(userIdx);
        }
        if (discount <= 40) {
            discountRateUserIdxMap.getOrDefault(40, new HashSet<>()).add(userIdx);
        }
    }

    public static void main(String[] args) {
        int[][] users = new int[][]{
                {40, 2900}, {23, 10000},
                {11, 5200}, {5, 5900},
                {40, 3100}, {27, 9200},
                {32, 6900}
        };
        int[] emoticons = new int[]{
                1300, 1500, 1600, 4900
        };
        System.out.println(Arrays.toString(solution(users, emoticons)));

    }
}
