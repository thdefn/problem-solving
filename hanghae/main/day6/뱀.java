package hanghae.main.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 뱀 {
    // row, col
    static List<int[]> movementList = List.of(
            new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0});

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        Set<String> apple = new HashSet<>();
        while (K-- > 0) {
            apple.add(br.readLine());
        }

        int L = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Deque<int[]> rowCol = new ArrayDeque<>(); // r, c
        Set<String> snake = new HashSet<>();
        int[] newHead = new int[]{1, 1};
        rowCol.add(newHead);
        snake.add(newHead[0] + " " + newHead[1]);

        int direction = 4; // 0 90 - 270
        int times = 0;
        boolean ended = false;
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            int interval = X - times; // 8
            int[] step = movementList.get(direction % 4);
            for (int i = 0; i < interval; i++) {
                times++;
                int[] head = rowCol.peekFirst();
                int r = head[0] + step[0];
                int c = head[1] + step[1];

                if (snake.contains((r + step[0]) + " " + (c + step[1]))) {
                    ended = true;
                    break;
                }

                newHead = new int[]{r, c};
                rowCol.addFirst(newHead);
                if (!apple.contains(r + " " + c)) {
                    int[] removed = rowCol.removeLast();
                    snake.remove(removed[0] + " " + removed[1]);
                }

                if (r > N || c > N || r < 1 || c < 1) {
                    ended = true;
                    break;
                }
                snake.add(newHead[0] + " " + newHead[1]);
            }

            if (ended) break;
            if ("L".equals(C)) {
                direction--;
            } else {
                direction++;
            }
        }

        int[] step = movementList.get(direction % 4);
        while (!ended) {
            times++;
            int[] head = rowCol.peekFirst();
            int r = head[0] + step[0];
            int c = head[1] + step[1];

            if (snake.contains((r + step[0]) + " " + (c + step[1]))) {
                ended = true;
            }

            newHead = new int[]{r, c};
            rowCol.addFirst(newHead);
            if (!apple.contains(r + " " + c)) {
                int[] removed = rowCol.removeLast();
                snake.remove(removed[0] + " " + removed[1]);
            }

            if (r > N || c > N || r < 1 || c < 1) {
                ended = true;
            }
            snake.add(newHead[0] + " " + newHead[1]);
        }

        System.out.println(times);


    }
}
