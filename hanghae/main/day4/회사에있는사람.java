package hanghae.main.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[][] input = new String[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            input[i][0] = st.nextToken();
            input[i][1] = st.nextToken();
        }

        // 1. 처음 나오는 이름이라면 set 에 추가 (입장 케이스)
        // 2. 두번째 나오는 이름이라면 set 에서 삭제 (나가는 케이스)
        Set<String> remainSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            if (remainSet.contains(input[i][0]))
                remainSet.remove(input[i][0]);
            else remainSet.add(input[i][0]);
        }

        for (String s : remainSet){
            System.out.println(s);
        }

    }
}
