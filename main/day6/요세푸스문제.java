package main.day6;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

// 1 2 3 4 5 6 7
// 3 6 2
public class 요세푸스문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringJoiner sj = new StringJoiner(", ");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            sj.add(String.valueOf(queue.poll()));
        }
        System.out.println("<" + sj + ">");
    }
}
