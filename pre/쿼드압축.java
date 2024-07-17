package pre;

import java.util.Arrays;

public class 쿼드압축 {
    // (0,0) (0,2) 4
    public static void main(String[] args) {
        int[][] arr = {
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}
        };
        System.out.println(Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[][] arr) {
        return press(0, 0, arr.length, arr);
    }

    public static int[] press(int x, int y, int size, int[][] arr) {
        int[] answer = new int[2];
        if (size == 1) {
            answer[arr[x][y]]++;
            return answer;
        }

        int[] lt = press(x, y, size / 2, arr);
        int[] lb = press(x, y + size / 2, size / 2, arr);
        int[] rt = press(x + size / 2, y, size / 2, arr);
        int[] rb = press(x + size / 2, y + size / 2, size / 2, arr);

        answer[0] += (lt[0] + lb[0] + rt[0] + rb[0]);
        answer[1] += (lt[1] + lb[1] + rt[1] + rb[1]);

        if (answer[0] == 0) return new int[]{0, 1};
        else if (answer[1] == 0) return new int[]{1, 0};
        return answer;
    }
}
