package main.day7;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 센터와마법의뿅망치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N
        long H = sc.nextLong(); // 키
        int T = sc.nextInt(); // 뿅망치 횟수

        Queue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            maxHeap.add(sc.nextLong());
        }

        // 1. 최대 거인에게 뿅망치를 쓰는 전락이므로, 최대 힙 사용
        // 1-1. 최대 힙에서 꺼내서 키를 반으로 나누고 다시 최대 힙에 넣어줌
        // 2. 최대 키가 1인 경우와 센티의 키를 넘은 경우에 대한 예외 처리
        int trial = 0;
        while (T-- > 0) {
            long height = maxHeap.poll();
            if (height < H) {
                maxHeap.add(height);
                break;
            }
            trial++;
            if (height == 1) {
                maxHeap.add(height);
                break;
            }
            long newHeight = height / 2;
            maxHeap.add(newHeight);
        }

        if (H > maxHeap.peek()) {
            System.out.println("YES");
            System.out.println(trial);
        } else {
            System.out.println("NO");
            System.out.println(maxHeap.poll());
        }


    }
}
