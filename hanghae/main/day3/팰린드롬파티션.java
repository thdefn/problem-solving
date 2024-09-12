package hanghae.main.day3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class 팰린드롬파티션 {
    // 1. memorization 위한 Map
    static Map<Integer, Integer> memo = new HashMap<>(); // number, palindromeCount

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(partitioning(n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static int partitioning(int n) {
        // 0. Base Case = 1, 1이면 더이상 파티셔닝 불가하기 때문
        if (n == 1) {
            memo.put(1, 1);
            return 1;
        }

        int count = 1;
        // 1. 삼등분 or 이등분으로 파티셔닝
        // 이때 최대 n/2 까지 파티셔닝 가능함
        for (int i = 1; i <= n / 2; i++) {
            // 1-2. 파티셔닝한 수에 대해 다시 파티셔닝
            if (memo.containsKey(i))
                count += memo.get(i);
            else count += partitioning(i);
        }
        memo.put(n, count);

        return count;
    }
}
