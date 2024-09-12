package hanghae.main.day14;

import java.util.Scanner;
// 17736 188
public class 게임을만든동준이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = sc.nextInt();
        }


        // 뒷 순서부터 차례로, 바로 뒤의 배열보다 크거나 같은지 체크함
        // 크거나 같다면, 바로 뒤의 배열 -1 로 스코어 수정
        int answer = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (score[i] >= score[i + 1]) {
                int changedScore = score[i + 1] - 1;
                answer += (score[i] - changedScore);
                score[i] = changedScore;
            }
        }

        System.out.println(answer);
    }
}
