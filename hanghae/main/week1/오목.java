package hanghae.main.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 오목 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[19][19];
        List<int[]> placed = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine() + " ");
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > 0) placed.add(new int[]{i, j});
            }
        }

        int winner = 0;


        int i = 0;
        int j = 0;
        for (int[] ij : placed) {
            i = ij[0];
            j = ij[1];
            if (checkDown(i, j)) {
                winner = arr[i][j];
            } else if (checkRight(i, j)) {
                winner = arr[i][j];
            } else if (checkLeft(i, j)) {
                winner = arr[i][j];
                j = j - 4;
            } else if (checkLeftDiagonal(i, j)) {
                winner = arr[i][j];
                i = i + 4;
                j = j - 4;
            } else if (checkRightDiagonal(i, j)) {
                winner = arr[i][j];
            }

            if (winner > 0) break;
        }

        System.out.println(winner);
        if (winner > 0) {
            System.out.println((i + 1) + " " + (j + 1));
        }
    }

    static boolean checkDown(int i, int j) {
        for (int k = 1; k <= 4; k++) {
            int x = i + k; // row
            if (x > 18) return false;
            if (arr[x][j] != arr[i][j]) return false;
        }

        if (i + 5 <= 18 && arr[i + 5][j] == arr[i][j]) return false;
        else if (i - 1 >= 0 && arr[i - 1][j] == arr[i][j]) return false;
        return true;
    }

    static boolean checkRight(int i, int j) {
        for (int k = 1; k <= 4; k++) {
            int y = j + k; // col
            if (y > 18) return false;
            if (arr[i][y] != arr[i][j]) return false;
        }

        if (j + 5 <= 18 && arr[i][j + 5] == arr[i][j]) return false;
        else if (j - 1 >= 0 && arr[i][j - 1] == arr[i][j]) return false;
        return true;
    }

    static boolean checkLeft(int i, int j) {
        for (int k = 1; k <= 4; k++) {
            int y = j - k; // col
            if (y < 0) return false;
            if (arr[i][y] != arr[i][j]) return false;
        }

        if (j - 5 >= 0 && arr[i][j - 5] == arr[i][j]) return false;
        else if (j + 1 <= 18 && arr[i][j + 1] == arr[i][j]) return false;
        return true;
    }

    static boolean checkLeftDiagonal(int i, int j) {
        for (int k = 1; k <= 4; k++) {
            int x = i + k; // row
            int y = j - k; // col
            if (x > 18) return false;
            if (y < 0) return false;
            if (arr[x][y] != arr[i][j]) return false;
        }


        if (i + 5 <= 18 && j - 5 >= 0 && arr[i + 5][j - 5] == arr[i][j])
            return false;
        else if (i - 1 >= 0 && j + 1 <= 18 && arr[i - 1][j + 1] == arr[i][j])
            return false;
        return true;
    }

    static boolean checkRightDiagonal(int i, int j) {
        for (int k = 1; k <= 4; k++) {
            int x = i + k; // row
            int y = j + k; // col
            if (x > 18) return false;
            if (y > 18) return false;
            if (arr[x][y] != arr[i][j]) return false;
        }

        if (i + 5 <= 18 && j + 5 <= 18 && arr[i + 5][j + 5] == arr[i][j])
            return false;
        else if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] == arr[i][j])
            return false;
        return true;
    }
}
