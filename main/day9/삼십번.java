package main.day9;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
// 67108 536
// 1. 부모 노드 value = 자식 노드 value / 2
// 2. 둘 중 작은 값을 찾아, 먼저 상위 탐색해서 Set 에 저장
// 3. 다른 값이 상위 탐색해서 Set 을 체크함 -> 공통의 상위 노드 찾음

public class 삼십번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int min = Math.min(A, B);
            int max = Math.max(A, B);
            Set<Integer> rootSet = new HashSet<>();
            rootSet.add(min);
            while (min > 1) {
                min = min / 2;
                rootSet.add(min);
            }

            while (!rootSet.contains(max)) {
                max = max / 2;
            }
            bw.write(max * 10 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
