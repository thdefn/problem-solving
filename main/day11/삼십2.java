package main.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1. 입력 : 최대 10^5 자리인 숫자
 *
 * 2. 30의 배수이려면 3의 배수이고, 10의 배수여야 함
 * 2-1. 주어진 숫자 sorting
 * 2-2. 3의 배수인지 체크 아니면 -1 리턴
 * 2-3. 10의 배수인지 체크
 *
 * 3. 출력 : 30의 배수가 아니면 -1, 30의 배수이면 가장 큰 숫자
 */
public class 삼십2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] number = input.toCharArray();
        Arrays.sort(number);

        int sum = 0;
        for (char c : number) {
            sum += (c - '0');
        }

        if (sum % 3 != 0 || number[0] > '0') {
            System.out.println("-1");
        } else {
            System.out.println(new StringBuilder(String.valueOf(number)).reverse());

        }
    }

}
