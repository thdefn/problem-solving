package main;

import java.util.Arrays;
import java.util.Scanner;

public class 평균은넘겠지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. C 개의 테스트 케이스가 주어진다
        int C = sc.nextInt();
        while (C-- > 0) {
            // 2. 학생 수 N으로 배열 초기화 및 데이터 받기
            int N = sc.nextInt();
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = sc.nextInt();
            }

            // 3. stream 을 이용해 average 구함
            double avg = Arrays.stream(scores).average().getAsDouble();
            // 4. average 를 넘는 학생 카운팅
            int aboveCount = 0;
            for (int i = 0; i < N; i++) {
                if (scores[i] > avg) {
                    aboveCount++;
                }
            }

            // 4. 결과를 formatting 해 적합한 포맷으로 출력
            System.out.printf("%.3f%%\n", (double) aboveCount / N * 100);
        }
    }
}
