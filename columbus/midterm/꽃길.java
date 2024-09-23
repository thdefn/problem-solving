package columbus.midterm;

import java.util.*;

public class 꽃길 {
    static int[][] drdc = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] flower = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                flower[i][j] = sc.nextInt();
            }
        }

        int ableRange = flower.length - 1;
        int[][] price = new int[N][N];
        for (int i = 1; i < ableRange; i++) {
            for (int j = 1; j < ableRange; j++) {
                int sum = flower[i][j];
                for (int[] d : drdc) {
                    int r = d[0] + i;
                    int c = d[1] + j;
                    sum += flower[r][c];
                }
                price[i][j] = sum;
            }
        }


        System.out.println(dfs(price, new boolean[N][N], 0, 0));


    }

    static int dfs(int[][] price, boolean[][] visited, int selected, int sum) {
        if (selected == 3)
            return sum;

        int min = Integer.MAX_VALUE;
        int ableRange = price.length - 1;
        for (int i = 1; i < ableRange; i++) {
            for (int j = 1; j < ableRange; j++) {
                if (!isSelected(visited, i, j)) {
                    checkSelected(visited, i, j);
                    min = Math.min(min, dfs(price, visited, selected + 1, sum + price[i][j]));
                    uncheckSelected(visited, i, j);
                }
            }
        }

        return min;
    }

    static boolean isSelected(boolean[][] visited, int i, int j) {
        return visited[i][j] || visited[i + 1][j] || visited[i][j + 1] || visited[i][j - 1] || visited[i - 1][j];
    }

    static void checkSelected(boolean[][] visited, int i, int j) {
        visited[i][j] = true;
        visited[i + 1][j] = true;
        visited[i - 1][j] = true;
        visited[i][j + 1] = true;
        visited[i][j - 1] = true;
    }

    static void uncheckSelected(boolean[][] visited, int i, int j) {
        visited[i][j] = false;
        visited[i + 1][j] = false;
        visited[i - 1][j] = false;
        visited[i][j + 1] = false;
        visited[i][j - 1] = false;
    }


}
