package hanghae.main.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < B.length; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 최대 힙 / 최소 힙 만들어서 A B 의 부분 배열의 합 저장
        // 최대 힙 : 값이 감소하는 방향
        // 최소 힙 : 값이 증가하는 방향
        Queue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 값이 감소
        for (int i = 0; i < A.length; i++) {
            long sum = A[i];
            maxHeap.add(sum);
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                maxHeap.add(sum);
            }
        }

        Queue<Long> minHeap = new PriorityQueue<>();
        for (int i = 0; i < B.length; i++) {
            long sum = B[i];
            minHeap.add(sum);
            for (int j = i + 1; j < B.length; j++) {
                sum += B[j];
                minHeap.add(sum);
            }
        }

        // 2. A의 부분 배열의 합과 B의 부분 배열의 합을 더해서, 비교함
        // a : maxHeap 의 top 값 b : minHeap 의 top 값
        // sum : 힙에 있는 값을 하나씩 빼서 더함
        // sum 이 T 보다 크면 maxHeap 을 지움
        // sum 이 T 보다 작으면 minHeap 을 지움
        // sum == T 인 경우 answer 카운팅
        long answer = 0;
        while (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            long sum = maxHeap.peek() + minHeap.peek();
            if (sum < T) {
                minHeap.poll();
            } else if (sum > T) {
                maxHeap.poll();
            } else {
                long a = maxHeap.poll();
                long cntA = 1;
                while (!maxHeap.isEmpty() && maxHeap.peek() == a) {
                    maxHeap.poll();
                    cntA++;
                }

                long b = minHeap.poll();
                long cntB = 1;
                while (!minHeap.isEmpty() && minHeap.peek() == b) {
                    minHeap.poll();
                    cntB++;
                }
                answer += (cntA * cntB);
            }
        }

        System.out.println(answer);

    }
}
