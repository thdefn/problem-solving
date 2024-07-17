package pre;

import java.util.Stack;

// 1924
// 1
// 9
// 92
// 94
public class 큰수만들기 {
    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4));

    }

    public static String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int removeCount = 0;
        for (char c : number.toCharArray()) {
            // 현재 값보다 작은 수는 다 삭제 (스택 안에는 현재 값보다 큰 값만 있다.)
            while (!stack.isEmpty() && stack.peek() < c && removeCount < k) {
                stack.pop();
                removeCount++;
            }
            // 스택에 집어넣는다.
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length() - k; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

}
