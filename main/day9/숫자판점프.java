package main.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 17568 200s
// 1. dfs 방식으로 가능한 조합을 찾아나간다
// 2. set 을 통해 조합 중 동일한 값은 제거한다
public class 숫자판점프 {
    static int[][] arr;
    static Set<String> answer = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                visit(i, j, 0, "");
            }
        }

        System.out.println(answer.size());
    }

    static void visit(int i, int j, int depth, String number) {
        if (depth == 6) {
            answer.add(number);
            return;
        }
        if (i > 4 || j > 4 || i < 0 || j < 0) {
            return;
        }

        number += arr[i][j];
        visit(i, j + 1, depth + 1, number);
        visit(i + 1, j, depth + 1, number);
        visit(i - 1, j, depth + 1, number);
        visit(i, j - 1, depth + 1, number);
    }
}
