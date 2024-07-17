package main;

import java.util.Scanner;

public class 주사위세개 {
    public static void main(String[] args) {
        int[] number = new int[7];
        Scanner sc = new Scanner(System.in);

        // 1. 주사위 수를 카운팅합니다. 주사위 눈을 인덱스로 해 배열 형태로 저장합니다
        for (int i = 0; i < 3; i++) {
            number[sc.nextInt()]++;
        }

        int answer = 0;
        // 2. 1~6 까지 모든 주사위 눈을 순회합니다.
        for (int i = 1; i <= 6; i++) {
            if (number[i] == 0) continue;
            // 3-1. 특정 눈이 세개인 경우, 혹은 두개인 경우 탐색을 종료합니다.
            // 3-2. 특정 눈이 한개라면, 가장 큰 눈금이 있거나 눈금이 두개인 케이스가 있을 수 있으므로 더 탐색합니다.
            if (number[i] == 3) {
                answer = 10000 + i * 1000;
                break;
            } else if (number[i] == 2) {
                answer = 1000 + i * 100;
                break;
            } else {
                answer = i * 100;
            }
        }

        System.out.println(answer);
    }
}
