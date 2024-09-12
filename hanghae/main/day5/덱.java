package hanghae.main.day5;

import java.io.*;
import java.util.*;
public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Dequeue dequeue = new Dequeue(N);
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if ("push_front".equals(command)) {
                int X = Integer.parseInt(st.nextToken());
                dequeue.pushFront(X);
            } else if ("push_back".equals(command)) {
                int X = Integer.parseInt(st.nextToken());
                dequeue.pushBack(X);
            } else if ("pop_front".equals(command)) {
                System.out.println(dequeue.popFront());
            } else if ("pop_back".equals(command)) {
                System.out.println(dequeue.popBack());
            } else if ("size".equals(command)) {
                System.out.println(dequeue.size());
            } else if ("empty".equals(command)) {
                System.out.println(dequeue.empty());
            } else if ("front".equals(command)) {
                System.out.println(dequeue.front());
            } else {
                System.out.println(dequeue.back());
            }
        }
    }

    static class Dequeue {
        final List<Integer> dequeue;

        Dequeue(int N) {
            this.dequeue = new ArrayList<>(N);
        }

        void pushFront(int X) {
            dequeue.add(0, X);
        }

        void pushBack(int X) {
            dequeue.add(X);
        }

        int popFront() {
            if (dequeue.isEmpty()) return -1;
            return dequeue.remove(0);
        }

        int popBack() {
            if (dequeue.isEmpty()) return -1;
            return dequeue.remove(dequeue.size() - 1);
        }

        int front() {
            if (dequeue.isEmpty()) return -1;
            return dequeue.get(0);
        }

        int back() {
            if (dequeue.isEmpty()) return -1;
            return dequeue.get(dequeue.size() - 1);
        }

        int size() {
            return dequeue.size();
        }

        int empty() {
            return dequeue.isEmpty() ? 1 : 0;
        }
    }
}
