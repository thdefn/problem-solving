package hanghae.main.day10;

import java.io.*;
import java.util.*;

/**
 1. 입력 : 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸, 체스판의 크기

 2. BFS 를 활용해 i,j -> r,c 인 최소 거리를 탐색한다.
 2-1. Queue 와 Set 을 활용해 BFS 를 구현함
 2-1-1. Queue 는 다음에 방문할 노드를 담고 있다
 2-1-2. Set 은 이미 방문한 노드를 담고 있다. -> 이미 방문한 노드가 아니라면 Queue 에 넣는다.
 2-1-3. r,c 를 방문하는 경우 탐색 종료

 3. 출력 : 최소 방문 횟수
 */
public class 나이트의이동 {

    static int[][] dxDy = { // r c
            {-1, -2}, {-2, -1}, {-1, 2}, {-2, 1},
            {1, -2}, {2, -1}, {1, 2}, {2, 1}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (T-- > 0) {
            int L = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(bfs(i, j, r, c, L)));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int i, int j, int r, int c, int L) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        visited.add(i + " " + j);
        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            if (r == rc[0] && c == rc[1])
                return rc[2];
            for (int[] xy : dxDy) {
                int nextR = rc[0] + xy[0];
                int nextC = rc[1] + xy[1];
                if (visited.contains(nextR + " " + nextC)) continue;
                if (nextR >= L || nextC >= L || nextR < 0 || nextC < 0)
                    continue;
                queue.add(new int[]{nextR, nextC, rc[2] + 1});
                visited.add(nextR + " " + nextC);
            }
        }
        return Integer.MAX_VALUE;
    }
}
