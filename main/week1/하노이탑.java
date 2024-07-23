package main.week1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 하노이탑 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (N <= 20) {
            List<String> process = new ArrayList<>();
            long K = move(N, 1, 3, 2, process);
            bw.write(K + "\n");
            for (int i = 0; i < process.size() - 1; i++) {
                bw.write(process.get(i) + "\n");
            }
            bw.write(process.get(process.size() - 1));
        } else {
            BigInteger K = move(N, 1, 3, 2);
            bw.write(K + "\n");
        }
        bw.flush();
    }

    // N 개의 원판을 to 로 옮기는 문제
    static long move(int N, int from, int to, int temp, List<String> process) {
        if (N == 1) {
            process.add(from + " " + to);
            return 1;
        }
        // 1. N-1 개 원판을 from -> temp 로 옮기는 문제
        long toTemp = move(N - 1, from, temp, to, process);
        // 2. 1개 원판을 from -> to 로 옮김
        process.add(from + " " + to);
        // 3. N-1 개 원판을 temp -> to 로 옮기는 문제
        long toTo = move(N - 1, temp, to, from, process);
        return toTemp + toTo + 1;
    }

    // N 개의 원판을 to 로 옮기는 문제
    static BigInteger move(int N, int from, int to, int temp) {
        if (N == 1) {
            return BigInteger.ONE;
        }
        BigInteger toTemp = move(N - 1, from, temp, to);
        return toTemp.add(toTemp).add(BigInteger.ONE);
    }
}
