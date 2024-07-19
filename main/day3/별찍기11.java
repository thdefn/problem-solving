package main.day3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 별찍기11 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        for (String s : drawPattern(N)) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static List<String> drawPattern(int N) {
        if (N == 3) {
            return List.of("  *  ", " * * ", "*****");
        }

        int next = N / 2;
        List<String> innerPattern = drawPattern(next);
        List<String> newPattern = new ArrayList<>();

        // 1. 최대 length 는 2 * N - 1 임 ex) N = 3 -> 5
        int maxLength = 2 * N - 1;
        // 2. 반 나눈 지점까지는 최대 length 에 맞게 padding 처리
        int cntOfBlank = (maxLength - innerPattern.get(0).length()) / 2;
        String blank = " ".repeat(cntOfBlank);
        StringBuilder sb;
        for (int i = 0; i < N / 2; i++) { // 3
            sb = new StringBuilder();
            sb.append(blank)
                    .append(innerPattern.get(i % next))
                    .append(blank);
            newPattern.add(sb.toString());
        }

        // 3. 아래 반 지점까지는 내부에 blank 추가됨
        blank = " ";
        for (int i = N / 2; i < N; i++) { // 3
            sb = new StringBuilder();
            sb.append(innerPattern.get(i % next))
                    .append(blank)
                    .append(innerPattern.get(i % next));
            newPattern.add(sb.toString());
        }

        return newPattern;

    }


}
