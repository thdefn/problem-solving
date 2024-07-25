package main.day7;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> typeCountMap = new HashMap<>();
            // 1. 의상의 종류 별 의상의 개수를 카운팅함
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String type = st.nextToken();
                typeCountMap.put(type, typeCountMap.getOrDefault(type, 0) + 1);
            }

            // 2. 경우의 수를 계산함
            // 의상의 종류 당 경우의 수는 (의상의 개수 + 모두 선택 안하는 케이스)
            int caseCount = 1;
            for (int count : typeCountMap.values()) {
                caseCount *= (count + 1);
            }
            // 경우의 수에서 모든 의상의 종류를 다 선택 안하는 케이스는 제외
            bw.write(--caseCount + "\n");
        }
        bw.flush();
        bw.close();
    }


}
