package hanghae.main.day7;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//  아이들을 만날 때마다 자신이 들고있는 가장 가치가 큰 선물 하나를 선물 => 최대 힙
// 1. 선물을 최대 힙에 넣는다.
// 2. 선물을 줄 때 최대 힙에서 꺼낸다
public class 크리스마스선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write("-1\n");
                } else bw.write(maxHeap.remove() + "\n");
            } else {
                while (st.hasMoreTokens()) {
                    maxHeap.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
