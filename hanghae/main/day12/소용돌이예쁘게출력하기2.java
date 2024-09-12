package hanghae.main.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 입력 :  r1, c1, r2, c2
 */
public class 소용돌이예쁘게출력하기2 {
    static int[][] drdc = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        int maxRow = Math.max(Math.abs(r1), Math.abs(r2));
        int maxCol = Math.max(Math.abs(c1), Math.abs(c2));
        int size = Math.max(maxRow, maxCol) * 2 + 1;

        String[][] drawing = new String[size][size];
        int r = size - 1;
        int c = size - 1;
        int d = 2;
        int number = size * size;
        int maxNumberLength = String.valueOf(number).length();

        while (number > 0) {
            // number 기록
            String paddingNum = String.valueOf(number);
            paddingNum = " ".repeat(maxNumberLength - paddingNum.length()) + paddingNum;
            drawing[r][c] = paddingNum;
            number--;

            if (number == 0) break;
            int nextR = r + drdc[d][0];
            int nextC = c + drdc[d][1];
            // 좌표의 범위가 아니거나, 이미 들른 곳이라면 방향 전환
            if (nextR < 0 || nextC < 0 || nextC >= size || nextR >= size || drawing[nextR][nextC] != null) {
                d = (d + 1) % 4;
                r = r + drdc[d][0];
                c = c + drdc[d][1];
            } else {
                r = nextR;
                c = nextC;
            }
        }


        int startRowIdx = r + r1; // 3-2    -> 1
        int startColIdx = c + c1; // 3+2    -> 5
        int h = r2 - r1 + 1; // 3
        int w = c2 - c1 + 1; // 2

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(drawing[i + startRowIdx][j + startColIdx]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
