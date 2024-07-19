package main.day3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 칸토어집합 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.isBlank() || str.isEmpty()) break;
            int N = Integer.parseInt(str);
            String init = "-".repeat((int) Math.pow(3, N));
            bw.write(cantor(init) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static String cantor(String cantorSet) {
        // 1. base case 작성
        if (cantorSet.length() == 1) {
            return cantorSet;
        }

        // 2. 주어진 문자열 3등분
        int dividedLen = cantorSet.length() / 3;
        StringBuilder sb = new StringBuilder(cantorSet);
        // 3. 재귀를 통해 첫번째, 세번째 조각의 칸토어 집합 구하기
        String res = cantor(sb.substring(0, dividedLen));
        // 4. 두번째 조각 칸토어 집합 처리
        sb = new StringBuilder();
        sb.append(res);
        sb.append(" ".repeat(dividedLen));
        sb.append(res);

        return sb.toString();

    }
}
