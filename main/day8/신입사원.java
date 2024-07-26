package main.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [6, 1] [4, 2] [7, 3] [1, 4] [2, 5] [3, 6] [5, 7]
 * 선발     선발   선발안됨  선발됨  선발안됨  선발안됨 선발안됨
 */
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            List<int[]> scores = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), " "); // 서류, 면접
                scores.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            // 1. 면접 점수 기준으로 정렬함
            scores.sort((o1, o2) -> o1[1] - o2[1]); // 면접 기준 정렬
            // 2. 선발자 중 가장 높은 서류 점수를 저장함
            // minOfSelectedDocScore 보다 서류 점수가 높다면, 선발 가능함
            int answer = 1;
            int minOfSelectedDocScore = scores.get(0)[0]; // 선발자 중 가장 높은 서류 점수
            for (int i = 1; i < scores.size(); i++) {
                int[] score = scores.get(i);
                // 점수가 하나라도 더 나은 경우 = 앞의 모든 지원자보다 서류 점수가 높아야 함
                if (score[0] < minOfSelectedDocScore) {
                    minOfSelectedDocScore = score[0];
                    answer++;
                }
            }
            System.out.println(answer);

        }
    }
}
