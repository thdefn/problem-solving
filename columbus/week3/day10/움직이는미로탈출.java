package columbus.week3.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 움직이는미로탈출 {
    static int[][] drdc = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] pan = new char[8][8];
        for (int i = 0; i < 8; i++) {
            pan[i] = sc.nextLine().toCharArray();
        }


        List<int[]> wall = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pan[i][j] == '#')
                    wall.add(new int[]{i, j});
            }
        }

        int curR = 7;
        int curC = 0;
    }
}
