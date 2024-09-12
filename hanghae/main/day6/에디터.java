package hanghae.main.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// abcdy x 스택 커서 스택
public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> front = new ArrayDeque<>();
        Stack<Character> back = new Stack<>();
        for (char c : br.readLine().toCharArray()) {
            front.add(c);
        }
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String s = br.readLine();
            char cmd = s.charAt(0);
            if (cmd == 'L') {
                if (front.isEmpty()) continue;
                back.add(front.removeLast());
            } else if (cmd == 'D') {
                if (back.isEmpty()) continue;
                front.addLast(back.pop());
            } else if (cmd == 'B') {
                if (front.isEmpty()) continue;
                front.removeLast();
            } else {
                char c = s.charAt(s.length() - 1);
                front.addLast(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!front.isEmpty()) {
            sb.append(front.removeFirst());
        }
        while (!back.isEmpty()) {
            sb.append(back.pop());
        }
        System.out.println(sb);
    }
}
