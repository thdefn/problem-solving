package main.day8;

import java.util.Arrays;
import java.util.Scanner;

public class 도서관 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 1. 양수인 경우 처리
        int idx = arr.length - 1;
        long step = 0;
        while (idx >= 0 && arr[idx] > 0) {
            step += arr[idx];
            idx -= M;
        }

        // 2. 음수인 경우 처리
        idx = 0;
        while (idx < arr.length && arr[idx] < 0) {
            step += Math.abs(arr[idx]);
            idx += M;
        }

        // 2. 양 끝값을 체크한다. 이건 제외하고 두배 처리
        step = step * 2 - Math.max(Math.abs(arr[arr.length - 1]), Math.abs(arr[0]));
        System.out.println(step);
    }
}
