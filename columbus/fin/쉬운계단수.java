package columbus.fin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 쉬운계단수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(bfs(N));
    }

    static int bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            queue.add(i);
        }

        int numberOfCase = 0;
        while (N-- > 0) {
            int qSize = queue.size();
            numberOfCase = qSize;
            for (int i = 0; i < qSize; i++) {
                int x = queue.poll();

                for (int nextX : new int[]{x + 1, x - 1}) {
                    if (nextX < 0 || nextX > 9) continue;
                    queue.add(nextX);
                }
            }
        }

        return numberOfCase;
    }

}
