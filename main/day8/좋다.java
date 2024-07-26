package main.day8;

import java.util.Arrays;
import java.util.Scanner;

// 3 5 7
// 3 3 4 5 8 9 10
public class 좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        int answer = 0;
        // 1. 투포인터를 이용해 sum 이 arr[i] 가 되는 값을 찾음
        // 2. 이때 전체 범위 탐색하되 자신은 제외하도록 함
        for (int i = 0; i < arr.length; i++) {
            int l = 0;
            int r = arr.length - 1;

            while (l < r) {
                long sum = arr[l] + arr[r];
                if (r == i || sum > arr[i]) {
                    r--;
                } else if (l == i || sum < arr[i]) {
                    l++;
                } else {
                    answer++;
                    break;
                }
            }
        }


        System.out.println(answer);
    }

}
