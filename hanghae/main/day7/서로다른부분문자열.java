package hanghae.main.day7;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 서로다른부분문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        char[] ch = S.toCharArray();

        Set<String> set = new HashSet<>();
        // 1. i번째 문자로 시작한는 문자열을 순차적으로 set 에 저장
        for (int i = 0; i < ch.length; i++) {
            StringBuilder sb = new StringBuilder(Character.toString(ch[i]));
            set.add(sb.toString());
            for (int j = i + 1; j < ch.length; j++) {
                sb.append(ch[j]);
                set.add(sb.toString());
            }
        }

        // 2. set 의 크기 출력
        System.out.println(set.size());
    }
}
