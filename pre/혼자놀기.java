package pre;

import java.util.*;

public class 혼자놀기 {
    static Set<Integer> remainSet = new HashSet<>();

    public static void main(String[] args) {
        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    //  1 2 3 4 5 6 7 8
    // [8,6,3,7,2,5,1,4]
    public static int solution(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            remainSet.add(i + 1);
        }

        List<Integer> groupSize = new ArrayList<>();
        while (!remainSet.isEmpty()) {
            int beforeRemainSetSize = remainSet.size();
            selectGroup(cards);
            int afterRemainSetSize = remainSet.size();
            groupSize.add(beforeRemainSetSize - afterRemainSetSize);
        }

        if(groupSize.size() == 1) return 0;
        Collections.sort(groupSize);
        return groupSize.get(groupSize.size() - 1) * groupSize.get(groupSize.size() - 2);
    }

    public static void selectGroup(int[] cards) {
        int idx = 0;
        // remainSet 에 남아있는 값 선택
        while (!remainSet.contains(cards[idx]))
            idx++;

        // remainSet 에 없다면 ( 이미 열린 상자라면 ) break
        while (remainSet.contains(cards[idx])) {
            remainSet.remove(cards[idx]); // 카드 삭제
            idx = cards[idx] - 1; // 인덱스 갱신
        }
    }
}
