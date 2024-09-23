package columbus.week2.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringJoiner;

public class 단지번호붙이기 {
    static int[][] drdc = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Integer> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    pq.add(dfs(map, visited, i, j));
                }
            }
        }

        StringJoiner sj = new StringJoiner("\n");
        sj.add(String.valueOf(pq.size()));
        while (!pq.isEmpty()) {
            sj.add(String.valueOf(pq.poll()));
        }

        System.out.println(sj);

    }

    static int dfs(char[][] map, boolean[][] visited, int r, int c) {
        int count = 1;
        for (int[] d : drdc) {
            int nextR = d[0] + r;
            int nextC = d[1] + c;

            if (nextR >= map.length || nextR < 0 || nextC >= map.length || nextC < 0)
                continue;
            if (map[nextR][nextC] == '1' && !visited[nextR][nextC]) {
                visited[nextR][nextC] = true;
                count += dfs(map, visited, nextR, nextC);
            }
        }

        return count;
    }
}
