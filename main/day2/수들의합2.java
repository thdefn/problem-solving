package main.day2;

import java.util.Scanner;

public class 수들의합2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. 누적합을 구한다.
        // ex) [0, 1, 2, 3, 4]
        int[] acc = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            acc[i] = acc[i - 1] + arr[i];
        }


        // 2. 누적합 배열을 탐색한다.
        int answer = 0;
        for (int i = 0; i < acc.length; i++) {
            // 2-2. acc[k] - acc[i] = M 인 값이 존재한다면 answer 값 증가시킴
            if (isPossible(acc, i, M)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean isPossible(int[] acc, int idx, int M) {
        // 3. 이진 탐색을 통해 특정 값 찾기
        int searchValue = M + acc[idx];
        int left = idx;
        int right = acc.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (acc[mid] > searchValue) {
                right = mid - 1;
            } else if (acc[mid] < searchValue) {
                left = mid + 1;
            } else return true;
        }
        return false;
    }
}
