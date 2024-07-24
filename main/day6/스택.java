package main.day6;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {
    static class MyStack {
        Stack<Integer> stack = new Stack<>();

        void push(int X) {
            stack.push(X);
        }

        int pop() {
            if (stack.isEmpty()) return -1;
            return stack.pop();
        }

        int size() {
            return stack.size();
        }

        int empty() {
            if (stack.isEmpty()) return 1;
            return 0;
        }

        int top() {
            if (stack.isEmpty()) return -1;
            return stack.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyStack myStack = new MyStack();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if ("push".equals(command)) {
                int X = Integer.parseInt(st.nextToken());
                myStack.push(X);
            } else if ("pop".equals(command)) {
                bw.write(myStack.pop() + "\n");
            } else if ("size".equals(command)) {
                bw.write(myStack.size() + "\n");
            } else if ("empty".equals(command)) {
                bw.write(myStack.empty() + "\n");
            } else {
                bw.write(myStack.top() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
