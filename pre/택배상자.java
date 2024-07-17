package pre;

import java.util.ArrayDeque;
import java.util.Deque;

public class 택배상자 {

    public static void main(String[] args) {
        int[] order = {1,2,3,4,5};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        Deque<Integer> subStack = new ArrayDeque<>(); // LIFO stack

        int answer = 0;
        int idx = 0;
        int main = 1;
        while (idx < order.length) {
            if (order[idx] == main) {
                idx++;
                main++;
                answer++;
            } else if (!subStack.isEmpty() && order[idx] == subStack.peekLast()) {
                idx++;
                subStack.removeLast();
                answer++;
            } else {
                while (order[idx] > main) {
                    subStack.add(main++);
                }

                if (order[idx] != main && (subStack.isEmpty() || order[idx] != subStack.peekLast()))
                    break;
            }
        }

        return answer;
    }
}
