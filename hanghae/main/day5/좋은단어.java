package hanghae.main.day5;

import java.util.Scanner;
import java.util.Stack;

public class 좋은단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        while (N-- > 0) {
            String s = sc.next();
            if (isGood(s)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isGood(String word) {
        Stack<Character> stack = new Stack<>(); // 짝지어질 character 리스트
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            // 1-1. 현재 값과 스택의 top 값이 다르다면, 스택에 현재값을 넣는다. (나중에 짝지어져야 함)
            // 1-2. 현재 값과 스택의 top 값이 같다면 스택에서 제거
            if (stack.isEmpty() || cur != stack.peek()) {
                stack.add(cur);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
