package main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;
/**
 1. 입력 : 숫자 카드, 있는지 확인할 숫자들
 숫자 카드에 음수가 포함됨 -> counting 어려울듯
 메모리에 비해 숫자 개수가 큼 -> Set 의 사용이 어려울듯

 2. 이진 탐색으로 특정 숫자가 카드 내에 있는지 확인함
 2-1. 이진 탐색에 필요한 오름차순 솔팅

 3. 출력 : 각 수가 적힌 숫자 카드를 가지고 있으면 1을, 아니면 0 을 출력
 */
public class 숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] myCards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] numbers = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCards);

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < M; i++) {
            if (hasNumber(myCards, numbers[i])) {
                sj.add("1");
            } else sj.add("0");
        }

        System.out.println(sj);

    }

    static boolean hasNumber(int[] cards, int number) {
        int left = 0;
        int right = cards.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (cards[mid] < number) left = mid + 1;
            else if (cards[mid] > number) right = mid - 1;
            else return true;
        }
        return false;
    }
}
