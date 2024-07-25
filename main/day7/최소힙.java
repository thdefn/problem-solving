package main.day7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 최소힙 {
    static class MyMinHeap {
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        void add(int x) {
            priorityQueue.add(x);
        }

        int remove() {
            if (priorityQueue.isEmpty()) return 0;
            return priorityQueue.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MyMinHeap minHeap = new MyMinHeap();
        while (N-- > 0) {
            int x = sc.nextInt();
            if (x == 0) bw.write(minHeap.remove() + "\n");
            else minHeap.add(x);
        }

        bw.flush();
        bw.close();
    }
}
