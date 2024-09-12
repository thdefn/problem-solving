package hanghae.main.day2;

import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] nums = sc.next().toCharArray();

        int[] cnt = new int[10];
        for (char ch : nums) {
            cnt[ch - '0']++;
        }

        int answer = 0;
        for (int i = 0; i < cnt.length - 1; i++) {
            if (i != 6) {
                answer = Math.max(cnt[i], answer);
            }
        }
        answer = Math.max((cnt[6] + cnt[9] + 1)/2, answer);
        System.out.println(answer);
    }
}
