package main.day11;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * 1. 입력 : 문자열 A, B
 *
 * 2.
 * 2-1. A B 의 첫글자와 마지막 글자가 동일한지 체크
 * 2-2. A 의 char 을 카운팅해, B 와 카운팅이 동일한지 체크
 * 2-3. A 와 B 에서 모음을 제거하고, 결과가 동일한지 체크한다.
 *
 * 3.출력 : 조건을 만족한다면 YES, 만족하지 않는다면 NO
 */
public class 두라무리휴지 {
    static Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    static int[] cnt = new int['z' - 'a' + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        char[] origin = a.toCharArray();
        char[] otherWord = b.toCharArray();

        boolean answer = true;
        if (origin[0] != otherWord[0] || origin[N - 1] != otherWord[N - 1])
            answer = false;
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                cnt[origin[i] - 'a']++;
                if (vowels.contains(origin[i])) continue;
                sb.append(origin[i]);
            }
            String originRemoved = sb.toString();
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (cnt[otherWord[i] - 'a'] < 1) {
                    answer = false;
                    break;
                }
                cnt[otherWord[i] - 'a']--;
                if (vowels.contains(otherWord[i])) continue;
                sb.append(otherWord[i]);
            }
            String otherWordRemoved = sb.toString();
            if (answer && !Objects.equals(originRemoved, otherWordRemoved))
                answer = false;
        }
        System.out.println(answer ? "YES" : "NO");

    }

}
