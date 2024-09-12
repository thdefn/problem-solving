package hanghae.main.day5;

import java.util.Scanner;

// f(n) = a1n + a0
// g(n) = cn
public class 점근적표기1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c = sc.nextInt();
        int n0 = sc.nextInt();

        int answer = 1;
        // a1 보다 c가 작다면 => g(n)이 하한이라면 무조건 만족 x
        // a1 보다 c가 큰 경우 엣지 케이스인 n0일때만 살피면 됨
        if (a1 > c) {
            answer = 0;
        } else if (a1 * n0 + a0 > c * n0) {
            answer = 0;
        }
        System.out.println(answer);
    }

}
