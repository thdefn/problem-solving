package main.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 162676 2192
 * 1. 입력 : 첫째줄 N / (작업시간 선행작업개수) / (작업시간 선행작업개수 선행작업들)
 * 2.
 * <p>
 * 3. 출력 : 모든 작업을 완료하기 위해 필요한 최소 시간
 */
public class 작업 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] pre = new boolean[N][N];
        int[][] works = new int[N][2]; // 시간 , 선행작업 카운팅
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        int[] dp = new int[N];


        for (int i = 0; i < N; i++) {
            // 시간을 저장함
            st = new StringTokenizer(br.readLine(), " ");
            works[i][0] = Integer.parseInt(st.nextToken());
            int preWorkSize = Integer.parseInt(st.nextToken());
            // 선행 작업의 수를 저장함
            works[i][1] = preWorkSize;
            // 선행 작업의 수가 0 이라면 큐에 넣어둠
            if (preWorkSize == 0) {
                queue.add(i);
            }
            // 선행 작업의 pre 로 현재 작업을 기록
            for (int j = 0; j < preWorkSize; j++) {
                int preWork = Integer.parseInt(st.nextToken());
                pre[i][preWork - 1] = true;
            }
        }



        while (!queue.isEmpty()) {
            int work = queue.poll();
            // 이 작업의 선행작업 중 가장 늦게 끝난 시간으로 시간 세팅
            dp[work] = works[work][0];
            for (int i = 0; i < N; i++) {
                if (pre[work][i]) {
                    dp[work] = Math.max(dp[i] + works[work][0], dp[work]);
                }
            }
            // 이 선행작업과 연관된 작업의 선행작업 수를 줄여줌
            for (int j = 0; j < N; j++) {
                if (pre[j][work])
                    works[j][1]--;
                else continue; // 큐에 있는 애들을 중복으로 큐에 넣지 않게 하기 위함

                // 한번도 들리지 않았다면 큐에 넣어줌
                if (dp[j] == 0 && works[j][1] == 0) {
                    queue.add(j);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

}
