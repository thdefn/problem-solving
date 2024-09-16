package columbus.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도영이가만든맛있는음식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] sour = new int[N];
        int[] bitter = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }


        long minDiff = Integer.MAX_VALUE;
        // 1. 맛 중 하나는 반드시 선택해야 한다 -> 하나는 반드시 선택되게 모든 인덱스를 시작 지점으로 선택한다.
        for (int i = 0; i < N; i++) {
            // 2. dfs 결과가 최소가 되게 이전 최솟값과 비교한다.
            minDiff = Math.min(dfs(sour, bitter, i + 1, sour[i], bitter[i]), minDiff);
        }
        System.out.println(minDiff);
    }


    static long dfs(int[] sour, int[] bitter, int index, long totalSour, long totalBitter) {
        if (index >= sour.length)
            return Math.abs(totalBitter - totalSour);

        // 1. index 를 select 함
        long selectResult = dfs(sour, bitter, index + 1, totalSour * sour[index], totalBitter + bitter[index]);

        // 2. index 를 select 하지 않음
        long noSelectResult = dfs(sour, bitter, index + 1, totalSour, totalBitter);

        return Math.min(selectResult, noSelectResult);
    }
}
