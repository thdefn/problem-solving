package main.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2번째 문제 13975
 *
 *
 * 1. 입력 : 테스트 케이스 개수, 1) 장의 수, 2) 파일의 크기
 * 2. 하나의 파일로 합칠 때 필요한 최소 비용
 * 3. 작은 애들끼리 합친다 -> 최소힙을 활용하기
 * <p>
 * 3. 출력 : 최소 비용
 */
public class 파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            Queue<Long> minHeap = new PriorityQueue<>();
            for (int i = 0; i < K; i++)
                minHeap.add(Long.parseLong(st.nextToken()));

            long price = 0;
            while (minHeap.size() > 1) {
                long c1 = minHeap.poll();
                long c2 = minHeap.poll();
                long x = c1 + c2;
                price += x;
                minHeap.add(x);
            }
            System.out.println(price);
        }

    }
}
