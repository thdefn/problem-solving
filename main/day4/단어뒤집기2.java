package main.day4;

import java.util.Scanner;

// <tag>hello world<bag><sag><dag>python : 반례
public class 단어뒤집기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int startIdx = 0;
        int endIdx = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            // 1. > 일 경우 i + 1 이 단어의 시작 or 새로운 태그의 시작
            // 1-1. 그 이전 값들은 태그 값이므로 전부 append 처리 (마지막 단어의 인덱스 - i + 1)
            // 1-2. 다음에도 태그일 경우를 고려해 endIdx 를 startIdx 로 변경
            // 2. < 일 경우 i - 1 이 단어의 끝 인덱스 or 새로운 태그의 시작
            // 2-1. 새로운 태그의 시작이라면 startIdx 가 i 임
            // 2-2. 단어의 끝이라면 단어 뒤집기 처리
            if (cur == '>') {
                startIdx = i + 1;
                sb.append(S, endIdx, startIdx);
                endIdx = startIdx;
            } else if (cur == '<' && startIdx != i) {
                endIdx = i;
                String[] words = S.substring(startIdx, endIdx).split(" ");
                for (int j = 0; j < words.length - 1; j++) {
                    sb.append(switchWord(words[j])).append(" ");
                }
                sb.append(switchWord(words[words.length - 1]));
            }
        }

        // 3. 마지막이 단어의 끝인 경우 별도 처리 -> 태그가 없어 for 문 처리 불가함
        if (S.charAt(S.length() - 1) != '>') {
            String[] words = S.substring(startIdx).split(" ");
            for (int j = 0; j < words.length - 1; j++) {
                sb.append(switchWord(words[j])).append(" ");
            }
            sb.append(switchWord(words[words.length - 1]));
        }

        System.out.println(sb);
    }

    public static String switchWord(String str) {
        char[] chars = str.toCharArray();
        int median = str.length() / 2; // abcd
        for (int i = 0; i < median; i++) {
            char a = chars[i];
            char b = chars[str.length() - i - 1];
            chars[i] = b;
            chars[str.length() - i - 1] = a;
        }
        return String.valueOf(chars);
    }
}
