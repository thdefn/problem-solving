package main.day15;

import java.util.Scanner;

public class 우주탐사선2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        boolean[] visited = new boolean[N];
        visited[K] = true;
        int minDist = dfs(K, N - 1, dist, visited, 0);
        System.out.println(minDist);
    }


    static int dfs(int i, int depth, int[][] dist, boolean[] visited, int sumOfDist) {
        if (depth == 0)
            return sumOfDist;

        int minDist = 1001;
        // 들르지 않은 이웃 노드를 들려야 함
        for (int j = 0; j < dist.length; j++) {
            if (visited[j]) continue;
            visited[j] = true;
            minDist = Math.min(dfs(j, depth - 1, dist, visited, sumOfDist + dist[i][j]), minDist);
            visited[j] = false;
        }
        return minDist;
    }


}
