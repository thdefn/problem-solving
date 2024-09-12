package hanghae.main.day1;

import java.util.Scanner;

public class 설탕배달2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int left = 0;
        int right = N / 3;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, N)) {
                answer = (N - mid * 3) / 5 + mid;
                right = mid - 1; // 값을 찾았다면 값을 줄여봐야 함
            } else left++; // 값을 못찾았다면 범위 수정
        }
        System.out.println(answer);
    }

    public static boolean isPossible(int count3, int N) {
        int remain = N - count3 * 3;
        if (remain % 5 == 0)
            return true;
        return false;
    }
}
