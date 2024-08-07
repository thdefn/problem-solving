package topic.투포인터;

import java.util.Scanner;

public class 부분합 {
    public static void main(String[] args) {
        // 1. 입력을 받는다.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 2. 투포인터 방식으로 구하기
        // 2-1. 합이 S 보다 작다면 ? j를 증가
        // 2-2. 합이 S 보다 크다면 ? i를 증가
        // j 가 N - 1 일때, S 보다 작다면 더 이상 안봐도 됨
        // S 보다 크다면, S 보다 작아지는 시점까지 체크

        int i = 0;
        int j = 0;
        int sum = numbers[0];
        int minLength = Integer.MAX_VALUE;
        while (j < numbers.length - 1) {
            if (sum >= S) {
                minLength = Math.min(j - i + 1, minLength);
                sum -= numbers[i];
                i++;
            } else {
                j++;
                sum += numbers[j];
            }
        }

        while (sum >= S && i < numbers.length) {
            sum -= numbers[i];
            minLength = Math.min(j - i + 1, minLength);
            i++;
        }

        if(minLength == Integer.MAX_VALUE) minLength = 0;
        System.out.println(minLength);
    }
}
