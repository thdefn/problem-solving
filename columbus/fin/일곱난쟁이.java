package columbus.fin;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {
    static int[] heights;
    static int reduce;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
        }
        Arrays.sort(heights);

        int total = Arrays.stream(heights).sum();
        reduce = total - 100;

        boolean[] selected = new boolean[9];
        dfs(selected, 0, 0, 0);
        for (int i = 0; i < 9; i++) {
            if (!selected[i])
                System.out.println(heights[i]);
        }
    }


    static boolean dfs(boolean[] visited, int index, int sumOfHeight, int depth) {
        if (sumOfHeight > reduce) return false;
        if (depth == 2 && sumOfHeight == reduce)
            return true;
        else if (depth == 2)
            return false;

        boolean found = false;
        for (int i = index; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                found = dfs(visited, i + 1, sumOfHeight + heights[i], depth + 1);
                if (found) break;
                else visited[i] = false;
            }
        }
        return found;
    }
}
