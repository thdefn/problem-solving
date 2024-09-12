package hanghae.main.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] records = new String[N];
        for (int i = 0; i < N; i++) {
            records[i] = br.readLine();
        }

        // 1. userSet 을 ENTER 마다 갱신해서 set 의 크기로 answer 도출
        int answer = 0;
        Set<String> userSet = new HashSet<>();
        for (int i = 1; i < records.length; i++) {
            if ("ENTER".equals(records[i])) {
                answer += userSet.size();
                userSet = new HashSet<>();
            } else userSet.add(records[i]);
        }
        answer += userSet.size();

        System.out.println(answer);


    }
}
