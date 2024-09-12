package hanghae.main.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] titles = new String[N];
        for (int i = 0; i < N; i++) {
            titles[i] = br.readLine();
        }

        // 1. Map 을 이용해 타이틀 개수 카운팅
        Map<String, Integer> titleCountMap = new TreeMap<>(); // 책 제목 : 카운트
        for (String s : titles) {
            titleCountMap.put(s, titleCountMap.getOrDefault(s, 0) + 1);
        }

        // 2. max 값 찾아 answer 찾음
        int max = 0;
        String answer = "";
        for (String key : titleCountMap.keySet()) {
            int count = titleCountMap.get(key);
            if (count > max) {
                max = count;
                answer = key;
            }
        }

        System.out.println(answer);

    }
}
