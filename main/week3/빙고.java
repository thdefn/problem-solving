package main.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 입력 : 첫째 줄부터 다섯째 줄까지 빙고판에 쓰여진 수 / 여섯째 줄부터 열째 줄까지 사회자가 부르는 수가 차례대로 한 줄에 다섯 개씩
 * <p>
 * 2. 출력 : 사회자가 몇 번째 수를 부른 후 철수가 빙고를 외치게 되는지
 */
public class 빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[5][5];
        int[][] numberLocation = new int[26][2]; // i j
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                numberLocation[board[i][j]][0] = i;
                numberLocation[board[i][j]][1] = j;
            }
        }


        boolean[][] check = new boolean[5][5];

        int count = 0;
        int lineCount = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                count++;
                int number = Integer.parseInt(st.nextToken());
                int r = numberLocation[number][0];
                int c = numberLocation[number][1];
                check[r][c] = true;
                // 1. row 살펴보기
                // 2. col 살펴보기
                // 3. 대각선 살펴보기
                if (hasRowBingo(check, r, c)) lineCount++;
                if (hasColBingo(check, r, c)) lineCount++;
                if (hasLeftDiagonalBingo(check, r, c)) lineCount++;
                if (hasRightDiagonalBingo(check, r, c)) lineCount++;

                if(lineCount >= 3) break;
            }
            if(lineCount >= 3) break;
        }

        System.out.println(count);
    }

    static boolean hasColBingo(boolean[][] checked, int r, int c) {
        boolean hasBingo = true;
        for (int k = 1; k <= 4; k++) {
            int x = (r + k) % 5;
            if (!checked[x][c]) {
                hasBingo = false;
                break;
            }
        }
        return hasBingo;
    }


    static boolean hasRowBingo(boolean[][] checked, int r, int c) {
        boolean hasBingo = true;
        for (int k = 1; k <= 4; k++) {
            int y = (c + k) % 5;
            if (!checked[r][y]) {
                hasBingo = false;
                break;
            }
        }
        return hasBingo;
    }

    static boolean hasLeftDiagonalBingo(boolean[][] checked, int r, int c) {
        if (r + c != 4) return false;
        boolean hasBingo = true;
        // 4,0   3,1   2,2   1,3   0,4
        for (int k = 1; k <= 4; k++) {
            int x = (r + k) % 5;
            int y = 4 - x;
            if (!checked[x][y]) {
                hasBingo = false;
                break;
            }
        }
        return hasBingo;
    }

    static boolean hasRightDiagonalBingo(boolean[][] checked, int r, int c) {
        if (r != c) return false;
        boolean hasBingo = true;
        for (int k = 1; k <= 4; k++) {
            int x = (r + k) % 5;
            if (!checked[x][x]) {
                hasBingo = false;
                break;
            }
        }
        return hasBingo;
    }
}
