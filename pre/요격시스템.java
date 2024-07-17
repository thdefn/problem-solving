package pre;

import java.util.*;

public class 요격시스템 {
    public static void main(String[] args) {
        int[][] targets = new int[][]{
                {4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}
        };

//        int[][] targets = new int[][]{
//                {1, 2},{1, 3}, {3,4}, {0,4}
//        };
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int end = targets[0][1];
        answer++;

        for (int[] t : targets){
            if(end <= t[0]){
                answer++;
                end = t[1];
            }
        }
        return answer;
    }
}
