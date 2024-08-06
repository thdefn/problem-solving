package main.week3;

import java.util.Scanner;

public class 서강그라운드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = sc.nextInt();
        }

        // 플루이드 워셜 알고리즘을 이용해 모든 노드를 출발점으로 최단거리 체크
        int[][] dist = new int[n][n];
        final int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int l = sc.nextInt();
            dist[a][b] = l;
            dist[b][a] = l;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }


        // 모든 노드에 떨어진 경우 체크
        // 특정 노드에서 최단거리가 m 이내라면 itemCount 갱신
        int maxItemCount = 0;
        for (int[] distance : dist) {
            int itemCount = 0;
            for (int i = 0; i < n; i++) {
                if (distance[i] <= m)
                    itemCount += items[i];
            }
            maxItemCount = Math.max(maxItemCount, itemCount);
        }

        System.out.println(maxItemCount);

    }
}
