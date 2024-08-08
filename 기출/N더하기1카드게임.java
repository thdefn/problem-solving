package 기출;

public class N더하기1카드게임 {
    public static void main(String[] args) {
        int coin = 10;
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        System.out.println(solution(coin, cards));
    }

    public static int solution(int coin, int[] cards) {
        // 초기 처리
        int oneThird = cards.length / 3;
        boolean[] havingCards = new boolean[cards.length + 1];
        int cardPair = 0;
        for (int i = 0; i < oneThird; i++) {
            if (havingCards[cards.length + 1 - cards[i]])
                cardPair++;
            havingCards[cards[i]] = true;
        }

        int r = dp(coin, cards, havingCards, oneThird, cardPair, false);
        int maxRound = (r - oneThird) / 2;
        return Math.min(maxRound, (cards.length - oneThird) / 2) + 1;
    }

    // 최대한 카드 페어를 많이 만든다
    static int dp(int coin, int[] cards, boolean[] havingCards, int i, int cardPair, boolean isRoundEnd) {
        // 카드 페어를 계산한다.
        if (i > cards.length - 1) {
            return i;
        }

        if (havingCards[cards.length + 1 - cards[i]] && coin > 0) {
            cardPair++;
        }

        if (isRoundEnd && cardPair > 0) cardPair--;
        else if(isRoundEnd) return i;

        int maxRound = i;
        // 페어가 없다면 선택하지 않는 경우를 체크한다.
        // 하지만 페어가 있다면 선택하지 않는 경우는 체크하지 않는다.
        if (!havingCards[cards.length + 1 - cards[i]]) {
            // 선택하지 않는 경우
            maxRound = dp(coin, cards, havingCards, i + 1, cardPair, !isRoundEnd);
        }
        // 선택하는 경우
        havingCards[cards[i]] = true;
        maxRound = Math.max(dp(coin - 1, cards, havingCards, i + 1, cardPair, !isRoundEnd), maxRound);
        havingCards[cards[i]] = false;

        return maxRound;

    }
}
