package main.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1. 문제 번호로 난이도를 찾을 수 있어야 함
// 2. 문제의 난이도로 가장 어려운 문제와 가장 쉬운 문제를 찾을 수 있어야 함 -> 정렬 필요
// 3. 문제가 추가된다 -> 정렬 업데이트 필요
// 4. 문제가 삭제된다 -> 정렬 업데이트 필요

// 난이도 큰 것 + 문제 번호 큰 것 우선 정렬  : 최대 힙
// 난이도 쉬운 것 + 문제 번호 작은 것 우선 정렬  : 최소 힙 사용
// 문제의 삭제와 관련한 부분은 contained Map 을 두어서, 여기에 없으면 없는걸로 함
public class 문제추천시스템1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0])
                    return o2[1] - o1[1];
                return o2[0] - o1[0];
            }
        });
        Queue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        Map<Integer, Integer> contained = new HashMap<>();


        // 1. 문제를 최대힙, 최소힙, Map (문제 번호:난이도) 로 저장
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int P = Integer.parseInt(st.nextToken()); // 문제번호
            int L = Integer.parseInt(st.nextToken()); // 난이도

            // 난이도 문제번호
            int[] prob = new int[]{L, P};
            maxHeap.add(prob);
            minHeap.add(prob);
            contained.put(P, L);
        }


        // 2. 조회 시 최대 힙이나 최소 힙을 사용
        // 3. 조회 시 Map 에 포함된 값인지 체크
        // 4. 삭제나 추가 시 Map 을 업데이트 함
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            if ("recommend".equals(cmd)) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) { // 가장 어려운 문제
                    while (!contained.containsKey(maxHeap.peek()[1])
                            || contained.get(maxHeap.peek()[1]) != maxHeap.peek()[0]) {
                        maxHeap.poll();
                    }
                    System.out.println(maxHeap.peek()[1]);
                } else { // 가장 쉬운 문제
                    while (!contained.containsKey(minHeap.peek()[1])
                            || contained.get(minHeap.peek()[1]) != minHeap.peek()[0]) {
                        minHeap.poll();
                    }
                    System.out.println(minHeap.peek()[1]);
                }
            } else if ("add".equals(cmd)) {
                int P = Integer.parseInt(st.nextToken()); // 문제번호
                int L = Integer.parseInt(st.nextToken()); // 난이도
                int[] prob = new int[]{L, P}; // 난이도 문제번호
                maxHeap.add(prob);
                minHeap.add(prob);
                contained.put(P, L);
            } else {
                int P = Integer.parseInt(st.nextToken()); // 문제번호
                contained.remove(P);
            }
        }

    }
}
