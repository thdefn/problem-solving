package main.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    static int visitCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        br.close();

        System.out.println(visit((int) Math.pow(2, N), 0, 0, r, c));

    }

    public static int visit(int range, int i, int j, int r, int c) {
        if (range == 1 && i == r && j == c) {
            return visitCount;
        }

        int nextRange = range / 2;
        if (r < i + nextRange && c < j + nextRange) {
            return visit(nextRange, i, j, r, c);
        } else if (r < i + nextRange && c >= j + nextRange) {
            visitCount += nextRange * nextRange;
            return visit(nextRange, i, j + nextRange, r, c);
        } else if (r >= i + nextRange && c < j + nextRange) {
            visitCount += nextRange * nextRange * 2;
            return visit(nextRange, i + nextRange, j, r, c);
        } else {
            visitCount += nextRange * nextRange * 3;
            return visit(nextRange, i + nextRange, j + nextRange, r, c);
        }
    }

}
