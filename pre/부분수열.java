package pre;

import java.util.Arrays;

public class 부분수열 {
    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        System.out.println(Arrays.toString(solution(sequence, k)));

    }
    public static int[] solution(int[] sequence, int k) {
        // 1. 누적합 구하기
        int[] answer = new int[2];
        long[] arr = new long[sequence.length + 1];
        for (int i = 0; i < sequence.length; i++) {
            arr[i + 1] = arr[i] + sequence[i];
        }

        for (int size = 1; size <= sequence.length; size++) { // 부분 수열의 사이즈
            int idx = binarySearch(arr, size, k);
            if (idx != -1)
                return new int[]{idx - size, idx - 1};
        }

        return new int[]{0, 0};
    }

    public static int binarySearch(long[] arr, int size, int k) {
        int left = size;
        int right = arr.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] - arr[mid - size] < k) {
                left = mid + 1;
            } else if (arr[mid] - arr[mid - size] > k) {
                right = mid - 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
