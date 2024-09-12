package hanghae.main.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 1       5
 * 1       2 5
 * 1 2     5 10
 * -99 1 2      5 10
 */
// 내가 찾고자 하는 값은 중간값
// minHeap 과 maxHeap 을 두 개 둬서 사이즈를 유지하자
// maxHeap 에는 ~ 중앙값까지 넣고, minHeap 에는 중앙값 이상을 넣기
public class 가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (maxHeap.isEmpty() || maxHeap.peek() > number) {
                maxHeap.add(number);
            } else minHeap.add(number);


            int totalSize = minHeap.size() + maxHeap.size();
            int mid = (totalSize + 1) / 2;
            while (maxHeap.size() < mid) {
                maxHeap.add(minHeap.poll());
            }
            while (maxHeap.size() > mid) {
                minHeap.add(maxHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.print(sb);
    }
}
