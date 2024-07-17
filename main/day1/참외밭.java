package main.day1;

import java.util.Scanner;

/**
 * 케이스 정리
 *
 * 4 2 3 1 3 1
 * 2 3 1 3 1 4
 * 3 1 3 1 4 2
 * 1 3 1 4 2 3 : 처음 제출에서 놓친 케이스
 * 1 4 2 3 1 3
 */


public class 참외밭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        // 1. 위상과 길이를 입력받는다.
        int[] len = new int[6];
        int[] loc = new int[6];
        for (int i = 0; i < 6; i++) {
            loc[i] = sc.nextInt();
            len[i] = sc.nextInt();
        }

        // 2. 슬라이딩 윈도우 방식으로 위상에서 동일한 숫자가 반복되는 패턴을 찾는다.
        int area = 0;
        for (int i = 0; i < 6; i++) {
            // 3. 동일한 숫자의 반복을 찾았다면, 답을 도출한다.
            if (loc[i] == loc[(i + 2) % 6] && loc[(i + 1) % 6] == loc[(i + 3) % 6]) {
                int minus = len[(i + 1) % 6] * len[(i + 2) % 6];
                int total = len[(i + 4) % 6] * len[(i + 5) % 6];
                area = total - minus;
                break;
            }
        }

        System.out.println(area * K);
    }
}
