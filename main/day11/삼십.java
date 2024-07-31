package main.day11;

import java.io.*;
import java.util.Arrays;


// 421  412  241  214  124

// 5421

// (1) 5412
// (2) 5241 5214    (1) 5124 5142
// 5421 /  4521 4251 4215  / 2415 2145 2154
// 5421 (4) 4521 4512 / 4152 4125  / 4215 4125

// 210 201  210
// 5241 5214 /   5142  5124   (3)
// 4521 4512  4251 4215  4152, 4125 / 2541  2514  2451  2415
public class 삼십 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] number = input.toCharArray();
        Arrays.sort(number);

        StringBuilder sb = new StringBuilder(String.valueOf(number)).reverse();
        input = sb.toString();
        boolean found = false;
        for (int i = 1; i < number.length; i++) {
            sb = new StringBuilder(input);
            long times = (long) Math.pow(2, i); // 위치는 length - i - 1
            int startIdx = number.length - i - 1;
            int lastIdx = number.length - 1;
            while (times-- > 0 && !found) {
                for (int j = startIdx; j < lastIdx; j++) {
                    char a = sb.charAt(j);
                    char b = sb.charAt(j + 1);
                    sb.setCharAt(j + 1, a);
                    sb.setCharAt(j, b);

                    if (isThirty(sb.toString())) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (found)
            bw.write(sb.toString());
        else bw.write("-1");
        bw.flush();
    }

    static boolean isThirty(String number) {
        int n = Integer.parseInt(number.substring(0, 2)) % 30;
        for (int i = 2; i < number.length(); i++) {
            n = n * 10 + (number.charAt(i) - '0');
            n %= 30;
        }
        if (n != 0)
            return false;
        return true;

    }

}
