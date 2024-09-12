package hanghae.main.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[][] jewel = new Integer[N][2];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가겨
            jewel[N] = new Integer[]{M, V};
        }

        // 2,3,10   2,3,10  10
        // (5, 25) (5 23) (2 99) (1 65)
        // 10 3 2
        // (1 65) (2 99) (5, 25) (5 23)
        // 1을 넣을 수 있는 가방은 2도 넣을 수 있다
        // List.of(65)  List.of(65, 99)  List.of(65, 99, 25, 23)

        Queue<Integer> bags = new PriorityQueue<>();
        int maxBag = -1;
        while (K-- > 0) {
            int bag = Integer.parseInt(br.readLine());
            bags.add(bag);
            maxBag = Math.max(maxBag, bag);
        }

        Arrays.sort(jewel, (o1, o2) -> o1[0] - o2[0]);

        Queue<Integer> maxWeight = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        Integer[] j;
        int bag;
        // (1 100) (2 200) (10 500) (13 300)
        // 10 10 10 14
        for (int i = 0; i < jewel.length; i++) {
            j = jewel[i]; // 1,65

            // bag 보다 현재 값의 무게가 커지는 시점에 answer 값 업데이트 (이전 최대값)
            // 앞으로 더이상 담을 수 있는 가방이 없는지 체크
            // 가방을 뺄 때 이 가방으로 넣을 수 있는 보물 있는지 체크
            while (!bags.isEmpty() && j[0] > bags.peek()) {
                bags.poll();
                answer += maxWeight.isEmpty() ? 0 : maxWeight.poll();
            }
            if (bags.isEmpty()) break;
            maxWeight.add(j[1]); // (100 200 500 )
        }

        while (!bags.isEmpty()) {
            answer += maxWeight.isEmpty() ? 0 : maxWeight.poll();
            bags.poll();
        }
        System.out.println(answer);


    }
}
