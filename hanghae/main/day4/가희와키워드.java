package hanghae.main.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가희와키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 메모장 키워드는 set 에 전부 추가
        Set<String> keywordSet = new HashSet<>();
        while (N-- > 0) {
            keywordSet.add(br.readLine());
        }


        // 2. 블로그 키워드를 set 에서 지움
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                keywordSet.remove(st.nextToken());
            }
            System.out.println(keywordSet.size());
        }

        br.close();
    }
}
