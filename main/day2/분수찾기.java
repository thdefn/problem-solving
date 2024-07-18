package main.day2;

import java.util.Scanner;

// 대각선을 한 row 로 보면, 1행에는 1개의 칸, 2행에는 2개의 칸, ...
// 이 row 에 대한 누적합을 구한다. 1, 3, ...
public class 분수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        long sum = 0;
        int i = 0;
        // 1. 누적합이 처음 X 를 넘어섰을 때, row 를 찾는다.
        while (sum < X) {
            sum += ++i;
        }
        // 2. 해당 row 에 대해 X가 몇번째인지 구한다.
        // i번째 row 가 우리가 찾는 row
        // i번째 row 에는 i 개의 칸이 있고, i개의 숫자로 구성됨
        int idx = (int) (i - sum + X - 1);
        int a = i - idx; // 내림차순 순서
        int b = idx + 1; // 오름차순 순서

        // 3-1. 짝수면 분모 감소, 분자 증가 방향
        // 3-2. 홀수면 분모 증가, 분자 감소 방향
        if (i % 2 == 0) {
            System.out.println(b + "/" + a);
        } else System.out.println(a + "/" + b);
    }
}
