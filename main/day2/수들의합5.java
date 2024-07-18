package main.day2;

import java.util.Scanner;

public class 수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. [1~N-1] 까지 담은 자연수 배열을 만듦
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }


        // 2. 투포인터 방식 이용
        // 2-1. sum 이 N 보다 작은 경우 범위를 늘려줌
        // 2-2. sum 이 N 보다 큰 경우 범위를 줄여줌
        // 2-3. sum 이 N 인 경우 answer 증가시킴 + 범위를 늘려줌
        int answer = 1;
        int left = 0;
        int right = 0;
        int sum = numbers[0];
        while (right < numbers.length - 1) {
            if (sum < N) {
                right++;
                sum += numbers[right];
            } else if (sum > N) {
                sum -= numbers[left];
                left++;
            } else {
                answer++;
                right++;
                sum += numbers[right];
            }
        }

        System.out.println(answer);
    }
}
