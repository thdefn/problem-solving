package hanghae.main.week3;

import java.util.Scanner;

/**
 * 1. 입력 : 문서 / 검색 단어
 * <p>
 * 3. 출력 : 단어 수
 */
public class 문서검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String document = sc.nextLine();
        String word = sc.nextLine();


        int i = 0;
        int searchEnd = document.length() - word.length();

        int count = 0;
        while (i <= searchEnd) {
            // i 에서 word 로 시작하는지 체크,
            if (document.startsWith(word, i)) {
                count++;
                i += word.length();
            } else i++;
        }

        System.out.println(count);
    }
}
