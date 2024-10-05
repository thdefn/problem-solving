package columbus.fin;

import java.util.Scanner;

public class 숫자고르기 {
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = sc.nextInt();
        }

    }

    static int dfs(boolean[] visited, int index, int depth){
        int next = numbers[index];
        if(visited[next])
            return depth;
        return dfs(visited, next, depth + 1);
    }
}
