package pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 우박수열 {
    public static void main(String[] args) {
        int[][] ranges = new int[][]{
                {0, 0}, {1, -2}, {3, -3}
        };
        int k = 3;
        System.out.println(Arrays.toString(solution(k, ranges)));
    }

    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> hail = new ArrayList<>();
        hail.add(k);
        while (k != 1) {
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
            hail.add(k);
        }

        double[] arrOfArea = new double[hail.size()];
        for (int i = 0; i < hail.size() - 1; i++) {
            int top = hail.get(i);
            int bottom = hail.get(i + 1);
            arrOfArea[i + 1] = arrOfArea[i] + (double) (top + bottom) /2;
        }

        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            int a = range[0];
            int b = bToIdx(hail.size(), range[1]);
            if(a > b) answer[i] = -1.0;
            else answer[i] = arrOfArea[b] - arrOfArea[a];
        }
        return answer;
    }

    public static int bToIdx(int n, int b){
        return n + b - 1;
    }
}
