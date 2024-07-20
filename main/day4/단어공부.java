package main.day4;

import java.util.Scanner;

public class 단어공부 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        // 1. 각 알파벳을 카운팅한다
        int[] cnt = new int['Z' - 'A' + 1];
        for (char ch : input) {
            cnt[Character.toUpperCase(ch) - 'A']++;
        }

        // 2. 카운팅 배열을 순회하며 max 값 체크
        int max = 0;
        String answer = "?";
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            // 2-1. max 값보다 현재 값이 큰 경우 갱신해줌
            // 2-2. max 값이 현재 값과 같다면 ? 처리
            if (cnt[i] > max) {
                max = cnt[i];
                answer = Character.toString(i + 'A');
            } else if (cnt[i] == max) {
                answer = "?";
            }
        }
        System.out.println(answer);
    }
}
