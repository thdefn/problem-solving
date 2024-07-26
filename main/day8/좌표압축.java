package main.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[][] nums = new Integer[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = new Integer[]{Integer.parseInt(st.nextToken()), i};
        }

        // 1. value 로 오름차순 sorting
        Arrays.sort(nums, ((o1, o2) -> o1[0] - o2[0]));
        // 2. 초기값은 0으로 설정, curValue 가 prevValue 보다 크면 +1 해줌
        int prevValue = nums[0][0];
        nums[0][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int curValue = nums[i][0];
            if (prevValue == curValue)
                nums[i][0] = nums[i - 1][0];
            else nums[i][0] = nums[i - 1][0] + 1;
            prevValue = curValue;

        }
        // 2. 인덱스로 오름차순 sorting
        Arrays.sort(nums, ((o1, o2) -> o1[1] - o2[1]));

        StringBuilder sb = new StringBuilder();
        for (Integer[] n : nums) {
            sb.append(n[0]).append(" ");
        }
        System.out.println(sb);
    }
}
