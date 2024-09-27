package columbus.week3.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {
    static int[][] drdc = new int[][]{
            {-2, -1}, {-1, -2},
            {-2, 1}, {-1, 2},
            {2, -1}, {1, -2},
            {2, 1}, {1, 2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int I = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int fromR = Integer.parseInt(st.nextToken());
            int fromC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int toR = Integer.parseInt(st.nextToken());
            int toC = Integer.parseInt(st.nextToken());

            System.out.println(bfs(I, fromR, fromC, toR, toC));
        }

    }

    static int bfs(int I, int fromR, int fromC, int toR, int toC) {
        int[][] distance = new int[I][I];
        for (int i = 0; i < I; i++) {
            Arrays.fill(distance[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{fromR, fromC});
        distance[fromR][fromC] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : drdc) {
                int nextR = d[0] + r;
                int nextC = d[1] + c;

                if (nextR >= I || nextR < 0 || nextC >= I || nextC < 0)
                    continue;

                if (distance[nextR][nextC] == -1) {
                    distance[nextR][nextC] = distance[r][c] + 1;
                    q.add(new int[]{nextR, nextC});
                }
            }
        }

        return distance[toR][toC];
    }
}
