package main;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. parametric search 이용
        // 가능한 봉투의 max, min 값으로 초기화 지정
        int left = 1;
        int right = N / 3;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, N)) {
                answer = mid;
                right = mid - 1; // 값을 찾았다면 값을 줄여봐야 함
            } else left++; // 값을 못찾았다면 범위 수정
        }
        System.out.println(answer);
    }

    // 2. 가능한 개수인지 체크
    public static boolean isPossible(int total, int N) {
        // 2-1. i 는 5킬로 봉투의 개수
        int i = 0;
        while (i * 5 <= N) {
            int remain = N - i * 5; // 남은 킬로그램
            // 2-2. 나머지 킬로그램을 3으로 나눌 수 있는지 체크
            if ((total - i) * 3 == remain)
                return true;
            i++;
        }
        return false;
    }
}
