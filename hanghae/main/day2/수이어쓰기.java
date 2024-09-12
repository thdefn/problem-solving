package hanghae.main.day2;

import java.util.Scanner;

public class 수이어쓰기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 1. N 의 자릿수 구하기
        int r = 1;
        int i = 0;
        while (N / r > 0) {
            i++;
            r *= 10;
        }
        r /= 10;

        // 2. 최대 자릿수로 쓰여지는 수 구하기 ex) 120 - 100 + 1 = 21
        // 2-2. length 계산
        int answer = (N - r + 1) * i--;

        // 3. 순차적으로 다음 자릿수로 쓰여지는 수 구하기 ex) 100 - 10 = 90
        while (r > 0) {
            answer += (r - r / 10) * i--;
            r /= 10;
        }

        System.out.println(answer);
    }
}
