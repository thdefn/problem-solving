package main.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 19028 196
// 1. #이 아니면 무조건 상하좌우 탐색함
// 2. visited 를 체크 : 동일한 노드 탐색 방지
public class 양치기꿍 {
    static char[][] arr;
    static boolean[][] visited;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        visited = new boolean[R][C];

        int survivedSheep = 0;
        int survivedWolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] != '#' && !visited[i][j]) {
                    int[] sheepWolf = new int[]{0, 0};
                    visit(i, j, sheepWolf);
                    if (sheepWolf[0] > sheepWolf[1])
                        survivedSheep += sheepWolf[0];
                    else survivedWolf += sheepWolf[1];
                }
            }
        }

        System.out.println(survivedSheep + " " + survivedWolf);
    }


    static void visit(int i, int j, int[] sheepWolf) {
        if (i >= R || i < 0 || j >= C || j < 0)
            return;
        if (visited[i][j]) return;
        visited[i][j] = true;

        if (arr[i][j] == '#') return;

        if (arr[i][j] == 'v') {
            sheepWolf[1]++;
        } else if (arr[i][j] == 'k') {
            sheepWolf[0]++;
        }

        visit(i + 1, j, sheepWolf);
        visit(i - 1, j, sheepWolf);
        visit(i, j + 1, sheepWolf);
        visit(i, j - 1, sheepWolf);
    }
}
