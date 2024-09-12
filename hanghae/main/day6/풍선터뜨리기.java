package hanghae.main.day6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringJoiner;

public class 풍선터뜨리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            deque.add(new int[]{sc.nextInt(), i + 1});
        }

        // -3 -1 2 1
        // -1 2 1     1 -1 2      2 1 -1
        StringJoiner sj = new StringJoiner(" ");
        int next;
        while (!deque.isEmpty()) {
            int[] ball = deque.poll();
            sj.add(String.valueOf(ball[1]));
            if (deque.isEmpty()) break;
            next = ball[0];
            int step = Math.abs(next);
            if (next > 0) { // 오른쪽 이동
                for (int i = 0; i < step - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                for (int i = 0; i < step; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }

        System.out.println(sj);
    }
}
