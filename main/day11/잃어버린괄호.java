package main.day11;

import java.util.Scanner;

// 55-(50+40-60+30) = 55 - 60 = -5
// 55-(50+40)-(60+30) = 55 - 90 - 90
// -55-(50+40)-(60+30)   [, 55, 50+40, 60+30]
// 55-50+40-60+30   [55, 50+40, 60+30]

/**
 * 1. 입력 : 수식
 * 가장 첫 숫자는 +
 *
 * 2.
 * 2-1. -와 - 사이에 괄호를 쳐야 한다.
 * 2-2. 수식을 - 기준으로 split 하기
 * 2-3. 첫번째 수식은 양수이고, 나머지 수식은 음수이다.
 * 2-4. + 기준으로 split 해서 합을 구한다.
 *
 * 3.출력 : 조건을 만족한다면 YES, 만족하지 않는다면 NO
 */
public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String formula = sc.next();
        String[] positiveNumbers = formula.split("-");

        String[] nums = positiveNumbers[0].split("\\+");
        int sum = 0;
        for (String s : nums) {
            sum += Integer.parseInt(s);
        }
        int answer = sum;

        for (int i = 1; i < positiveNumbers.length; i++) {
            nums = positiveNumbers[i].split("\\+");
            sum = 0;
            for (String s : nums) {
                sum += Integer.parseInt(s);
            }
            answer -= sum;
        }

        System.out.println(answer);
    }
}
