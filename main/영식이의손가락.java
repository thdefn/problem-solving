package main;

import java.util.Scanner;

public class 영식이의손가락 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long finger = sc.nextInt();
        long limit = sc.nextInt();

        // 1 과 5일 때는 예외
        long answer = 0;
        if (finger == 5 || finger == 1) {
            answer = limit * 8;
            answer += (finger - 1);
        } else {
            answer = limit * 4; // 3 * 4

            if (limit % 2 == 0) {
                answer += (finger - 1);
            } else answer += (5 - finger);
        }

        System.out.println(answer);

    }
}
