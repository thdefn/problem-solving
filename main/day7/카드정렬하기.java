package main.day7;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 1. 최소 사이즈의 카드 묶음 두개를 합친다.
// 2. 합쳐서 다시 minHeap 에 넣음
// 3. minHeap 의 크기가 1이 되면 답이 나온 것
public class 카드정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> minHeap = new PriorityQueue<>();
        while (N-- > 0) {
            minHeap.add(sc.nextInt());
        }


        int answer = 0;
        while (minHeap.size() > 1) {
            int deckA = minHeap.poll();
            int deckB = minHeap.poll();
            int combinedDeck = deckA + deckB;
            answer += combinedDeck;
            minHeap.add(combinedDeck);
        }

        System.out.println(answer);
    }
}
