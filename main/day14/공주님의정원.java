package main.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님의정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] flowers = new int[N][2]; // 피는 날, 지는 날
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startMon = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            flowers[i][0] = startMon * 100 + startDay;

            int endMon = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowers[i][1] = endMon * 100 + endDay;
        }

        // 지는 시간 내림차순, 피는 시간 오름차순
        Arrays.sort(flowers, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o2[1] - o1[1];
        });

        int lastStart = 1131;
        int count = 0;
        // 시작 시간 작은 순 정렬
        // lastStart 이후에 지는 꽃 중 오래 피는 값을 선택함
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < N; i++) {
            // lastStart 이후에 지는 꽃인데, minHeap 이 비어있지 않은 경우, 오래피는 값을 선택한다.
            if (lastStart > flowers[i][1] && !minHeap.isEmpty()) {
                lastStart = minHeap.poll();
                count++;
                minHeap.clear();
            }
            // 만약 lastStart 가 301 이전까지 핀다면 탐색 종료
            if (lastStart <= 301) break;
            // last start 이후에 지는 꽃이라면 일단 minHeap 에 넣는다.
            if (lastStart <= flowers[i][1]) {
                minHeap.add(flowers[i][0]);
            } else break; // 없는 경우 브레이크
        }


        if (!minHeap.isEmpty()) {
            lastStart = minHeap.poll();
            count++;
        }
        if (lastStart > 301) System.out.println("0");
        else System.out.println(count);

    }
}
