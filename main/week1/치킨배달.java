package main.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨배달 {

    static int[][] arr;
    static Set<String> memo = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        List<int[]> houses = new ArrayList<>();
        List<int[]> chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) houses.add(new int[]{i, j});
                else if (arr[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        System.out.println(selectChicken(houses, chicken, M));
    }

    // 폐업시킬 치킨 집 결정하기
    static int selectChicken(List<int[]> houses, List<int[]> chicken, int M) {
        if (chicken.size() == M) {
            int totalMinDist = 0;
            for (int[] ij : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int[] kl : chicken) {
                    int dist = Math.abs(ij[0] - kl[0]) + Math.abs(ij[1] - kl[1]);
                    minDist = Math.min(minDist, dist);
                }
                totalMinDist += minDist;
            }
            return totalMinDist;
        }

        memo.add(chicken.toString());
        // 1. 치킨집중에 하나 지우기
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < chicken.size(); i++) {
            List<int[]> copied = new ArrayList<>(chicken);
            copied.remove(i);
            if (memo.contains(copied.toString())) continue;
            minDist = Math.min(selectChicken(houses, copied, M), minDist);
        }

        return minDist; // 최소값 리턴
    }
}
