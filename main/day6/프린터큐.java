package main.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<int[]> queue;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] nums = new int[N][2];
            st = new StringTokenizer(br.readLine(), " ");
            queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                nums[i] = new int[]{Integer.parseInt(st.nextToken()), i};
                queue.add(nums[i]);
            }

            int value = nums[M][0];
            Arrays.sort(nums, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });


            int maxIdx = 0;
            int order = 1;
            while (nums[maxIdx][0] > value) {
                while (queue.peek()[0] != nums[maxIdx][0]) {
                    queue.add(queue.poll());
                }
                queue.poll();
                maxIdx++;
                order++;
            }

            // 이제 큐에는 구하고자 하는 애들보다 작거나 같은 애들만 있음
            // 작은 애들은 무시함
            while (M != queue.peek()[1]) {
                if (queue.poll()[0] == value)
                    order++;
            }
            System.out.println(order);
        }
    }
}
