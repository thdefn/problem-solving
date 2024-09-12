package hanghae.main.day5;

import java.io.*;
import java.util.*;

/**
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0
 */
public class 스도쿠 {
    static int[][] answer;
    static List<Integer> elements = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<int[]> toFind = new LinkedList<>();
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) toFind.add(new int[]{i, j});
            }
        }

        find(arr, toFind);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                bw.write(answer[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int[][] arr, List<int[]> toFind) {
        // 0. answer 이 여러 개 있을 수 있는 문제이므로, answer 이 있을 시 빠른 리턴
        if (answer != null) return;
        if (toFind.isEmpty()) {
            answer = arr;
            return;
        }

        int i = toFind.get(0)[0];
        int j = toFind.get(0)[1];
        Set<Integer> remain = new HashSet<>(elements);

        // 1. row 에 대한 중복 처리
        for (int k = 0; k < 9; k++) {
            remain.remove(arr[i][k]);
        }

        // 2. col 에 대한 중복 처리
        for (int k = 0; k < 9; k++) {
            remain.remove(arr[k][j]);
        }

        // 3. 3x3 에 대한 중복 처리
        int x = i / 3 * 3;
        int y = j / 3 * 3;
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                remain.remove(arr[x + k][y + l]);
            }
        }

        // 4. remain 에 남아있는 게 없다면 불가능한 케이스
        if (remain.isEmpty()) return;

        // 5. 다음으로 찾아야 할 원소 리스트 copy
        List<int[]> copied = new LinkedList<>(toFind);
        copied.remove(0);

        // 6. 주어진 arr copy
        int[][] copiedArr = new int[9][9];
        for (int k = 0; k < 9; k++) {
            copiedArr[k] = arr[k].clone();
        }
        for (int num : remain) {
            copiedArr[i][j] = num;
            find(copiedArr, copied);
        }
    }
}
