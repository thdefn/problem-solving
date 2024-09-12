package hanghae.main.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// 46316 620
public class 통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        // 최빈값 출력
        boolean isSecondMode = false;
        int numberCount = 1;
        int maxNumberCount = 0;
        int mode = 0;
        int sum = nums[0];
        for (int i = 1; i < N; i++) {
            // 이전 값과 달라지는 순간 이전 값이 최빈값인지 체크한다.
            if (nums[i] > nums[i - 1]) {
                // 넘버 카운트가 최대라면, 최빈값 업데이트
                // 최빈값이 업데이트될 때 두번째 최빈값인지 체크해둔다.
                if (maxNumberCount < numberCount) {
                    maxNumberCount = numberCount;
                    mode = nums[i - 1];
                    isSecondMode = false;
                }
                // 넘버 카운트가 동일하다면, 두번째 최빈값일 때만 업데이트
                else if (maxNumberCount == numberCount && !isSecondMode) {
                    mode = nums[i - 1];
                    isSecondMode = true;
                }
                // 최빈값인지 체크 이후 넘버 카운팅을 0으로 초기화
                numberCount = 0;
            }
            numberCount++;
            sum += nums[i];
        }

        // 마지막 값에 대한 최빈값 체크
        if (maxNumberCount < numberCount || (maxNumberCount == numberCount && !isSecondMode)) {
            mode = nums[N - 1];
        }

        double average = (double) sum / N;
        int median = nums[N / 2];
        int range = nums[nums.length - 1] - nums[0];

        System.out.println(Math.round(average));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);


    }
}
