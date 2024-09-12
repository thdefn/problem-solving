package hanghae.main.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 56012 708
public class 강의실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        // 시작 시간 오름차순으로 솔팅
        Arrays.sort(lectures, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        // 끝나는 시간 담은 큐
        Queue<Integer> endTimes = new PriorityQueue<>();
        int maxSize = 0;
        for (int i = 0; i < N; i++) {
            // 가장 먼저 끝나는 시간과 강의의 시작 시간 비교
            // 작거나 같다면 poll
            while (!endTimes.isEmpty() && endTimes.peek() <= lectures[i][0]){
                endTimes.remove();
            }
            endTimes.add(lectures[i][1]);
            maxSize = Math.max(endTimes.size(), maxSize);
        }

        System.out.println(maxSize);


    }
}
