package hanghae.main.day4;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class 파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        // 1. Map 을 이용해 extension 을 카운팅함
        // 1-1. TreeMap 을 사용해 오름차순 정렬되도록 함
        Map<String, Integer> extensionCountMap = new TreeMap<>(); // extension : count
        for (String s : input) {
            String ex = s.split("\\.")[1];
            extensionCountMap.put(ex, extensionCountMap.getOrDefault(ex, 0) + 1);
        }

        // 2. 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String k : extensionCountMap.keySet()) {
            bw.write(k + " " + extensionCountMap.get(k));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
