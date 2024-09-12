package hanghae.main.day11;

import java.io.*;

public class 회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (T-- > 0) {
            bw.write(isPalindrome(br.readLine()) + "\n");
        }
        bw.flush();

    }

    static int isPalindrome(String str) {
        // 회문인지 체크
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else break;
        }
        // 회문이라면 리턴
        if (left > right) return 0;

        // 유사 회문인지 체크
        if (isPalindrome(str, left, right - 1))
            return 1;
        else if (isPalindrome(str, left + 1, right))
            return 1;
        return 2;
    }

    static boolean isPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }

}
