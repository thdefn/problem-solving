package main.week2;

import java.util.*;

/**
 * 1 1697
 *
 * 1. 입력 : N, K
 * 2. 동생을 찾을 수 있는 가장 빠른 시간
 * 3. bfs 를 사용해 가장 빠른 시간을 구한다
 * <p>
 * 3. 출력 : 가장 빠른 시간
 */
public class 숨바꼭질 {
    // dx => x -1 / x + 1 / 2 * x

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(bfs(N, K));
    }

    static int bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(N);
        visited.add(N);

        int time = 0;
        boolean hasFound = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.poll();
                if (x == K) {
                    hasFound = true;
                    break;
                }
                int a = x - 1;
                int b = x + 1;
                int c = 2 * x;
                if (a >= 0 && a <= 100000 && !visited.contains(a)) {
                    queue.add(a);
                    visited.add(a);
                }
                if (b >= 0 && b <= 100000 && !visited.contains(b)) {
                    queue.add(b);
                    visited.add(b);
                }
                if (c >= 0 && c <= 100000 && !visited.contains(c)) {
                    queue.add(c);
                    visited.add(c);
                }
            }
            if (hasFound) break;
            time++;
        }
        return time;
    }
}
