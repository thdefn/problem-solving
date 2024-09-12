package hanghae.main.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 입력 : T, N, 카드에 적힌 알파벳
 * <p>
 * 2. 카드는 왼쪽 또는 오른쪽에 놓을 수 있음
 * <p>
 * 3. 출력 : 사전 순으로 가장 빠른 문자열
 */
public class 카드문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            char[] alphabets = br.readLine().replaceAll(" ", "").toCharArray();
            System.out.println(makeBestOrderWord(alphabets));
        }
    }

    static String makeBestOrderWord(char[] alpha) {
        StringBuilder sb = new StringBuilder();
        sb.append(alpha[0]);
        for (int i = 1; i < alpha.length; i++) {
            // 가장 앞의 알파벳보다 앞서는 단어라면 왼쪽에 배치
            if (sb.charAt(0) >= alpha[i])
                sb.insert(0, alpha[i]);
            // 아니라면 오른쪽에 배치
            else sb.append(alpha[i]);
        }
        return sb.toString();
    }
}
