package hanghae.main.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 치킨배달2 {

    static int[][] arr;

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
        System.out.println(selectChicken(houses, chicken, M, new HashSet<>()));
    }

    // 그냥 둘 치킨 집 선택하기
    static int selectChicken(List<int[]> houses, List<int[]> chicken, int M, Set<int[]> selected) {
        if (selected.size() == M) {
            int totalMinDist = 0;
            for (int[] ij : houses) {
                int minDist = Integer.MAX_VALUE;
                for (int[] kl : selected) {
                    int dist = Math.abs(ij[0] - kl[0]) + Math.abs(ij[1] - kl[1]);
                    minDist = Math.min(minDist, dist);
                }
                totalMinDist += minDist;
            }
            return totalMinDist;
        }

        // 1. 치킨집 중 하나 선택
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < chicken.size(); i++) {
            // 1-1. 현재 selected 되었다면 continue
            if (selected.contains(chicken.get(i))) continue;
            // 1-2. selected 에 추가
            Set<int[]> copied = new HashSet<>(selected);
            copied.add(chicken.get(i));
            minDist = Math.min(selectChicken(houses, chicken, M, copied), minDist);
        }

        return minDist; // 최소값 리턴
    }
}
