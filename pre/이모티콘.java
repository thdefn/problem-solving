package pre;

import java.util.*;

public class 이모티콘 {
    static Map<Integer, Set<Integer>> discountRateUserIdxMap = new HashMap<>(); // 40, [0,1]
    static List<Integer> discountRates = List.of(10, 20, 30, 40);

    public static void main(String[] args) {
        int[][] users = new int[][]{
                {40, 10000}, {25, 10000}
        };
        int[] emoticons = new int[]{
                7000, 9000
        };
        System.out.println(Arrays.toString(solution(users, emoticons)));

    }

    public static int[] solution(int[][] users, int[] emoticons) {
        for (int i = 0; i < users.length; i++) {
            addUserToDiscountRateUserIdxMap(users[i][0], i);
        }


        int[] userPaid = maximizeProfit(emoticons, 0, users);
        return calculateProfit(userPaid, users);
    }


    // user가 구매한 금액을 리턴함
    public static int[] maximizeProfit(int[] emoticons, int idx, int[][] users) {
        if (idx == emoticons.length) {
            return new int[users.length];
        }
        System.out.println("--" + idx);

        // 이모티콘을 몇퍼센트 할인할건지
        // 1) 40 % 인 경우
        int[] userPaid = maximizeProfit(emoticons, idx + 1, users);

        List<int[]> result = new ArrayList<>();
        Map<Integer, int[]> discountUserPaidMap = new HashMap<>();
        // 1. 이번 이모티콘을 할인율에 따라 구매 금액 업데이트한다.
        for (int discount : discountRates) {
            int discounted = emoticons[idx] * discount / 100;
            int[] tmp = userPaid.clone();
            for (int userIdx : discountRateUserIdxMap.get(discount)) {
                tmp[userIdx] += discounted;
            }
            discountUserPaidMap.put(discount, tmp);
            result.add(calculateProfit(tmp, users, discount));
        }
        // 2. 최종 이익을 구한다. -> 이모티콘 플러스 가입자, 이모티콘 판매액
        Collections.sort(result, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if (o2[0] == o1[0] && o2[1] == o1[1])
//                    return o2[2] - o1[2];
                if (o2[0] == o1[0])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });

        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
        System.out.println("----");

        return discountUserPaidMap.get(result.get(0)[2]);

    }

    public static int[] calculateProfit(int[] userPaid, int[][] users) {
        // idx - 끝까지 가격 순회하며 유저가 지불할 돈 계산
        int emoticonPlus = 0;
        int sumOfPaid = 0;
        for (int i = 0; i < userPaid.length; i++) {
            if (userPaid[i] >= users[i][1]) {
                emoticonPlus++;
                sumOfPaid -= userPaid[i];
            } else sumOfPaid += userPaid[i];
        }

        return new int[]{emoticonPlus, sumOfPaid};
    }


    public static int[] calculateProfit(int[] userPaid, int[][] users, int discount) {
        // idx - 끝까지 가격 순회하며 유저가 지불할 돈 계산
        int emoticonPlus = 0;
        int sumOfPaid = 0;
        for (int i = 0; i < users.length; i++) {
            //   System.out.println(sumOfPaid);
            if (userPaid[i] >= users[i][1]) {
                emoticonPlus++;
                sumOfPaid -= userPaid[i];
            } else sumOfPaid += userPaid[i];
        }

        return new int[]{emoticonPlus, sumOfPaid, discount};
    }

    public static void addUserToDiscountRateUserIdxMap(int discount, int userIdx) {
        if (discount == 40) {
            Set<Integer> userIdxSet = discountRateUserIdxMap.getOrDefault(40, new HashSet<>());
            userIdxSet.add(userIdx);
            discountRateUserIdxMap.put(40, userIdxSet);
        }
        if (discount >= 30) {
            Set<Integer> userIdxSet = discountRateUserIdxMap.getOrDefault(30, new HashSet<>());
            userIdxSet.add(userIdx);
            discountRateUserIdxMap.put(30, userIdxSet);
        }
        if (discount >= 20) {
            Set<Integer> userIdxSet = discountRateUserIdxMap.getOrDefault(20, new HashSet<>());
            userIdxSet.add(userIdx);
            discountRateUserIdxMap.put(20, userIdxSet);
        }
        if (discount >= 10) {
            Set<Integer> userIdxSet = discountRateUserIdxMap.getOrDefault(10, new HashSet<>());
            userIdxSet.add(userIdx);
            discountRateUserIdxMap.put(10, userIdxSet);
        }
    }
}
