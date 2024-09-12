package hanghae.main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 입력 : 점의 개수, 점의 좌표, 간선, 선분의 시작점과 끝점
 * <p>
 * 2. 주어진 점을 sorting
 * 3. Binary Search 를 활용해 선분의 시작점의 인덱스를 찾는다.
 * 3-1. 만약 인덱스를 찾지 못한다면 오른쪽에 위치한 인덱스를 리턴
 * 4. Binary Search 를 활용해 선분의 끝점의 인덱스를 찾는다.
 * 4-1. 만약 인덱스를 찾지 못한다면 오른쪽에 위치한 인덱스를 리턴
 * 4-1-1. 이 경우 인덱스를 하나 줄여줌
 * 3. 출력 : 선분 위에 점의 개수
 */
public class 선분위의점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N]; // number, idx
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int numberA = Integer.parseInt(st.nextToken());
            int numberB = Integer.parseInt(st.nextToken());
            int min = Math.min(numberA, numberB);
            int max = Math.max(numberA, numberB);
            int idxMin = binarySearch(min, arr);
            int idxMax = binarySearch(max, arr);
            // idxMax 가 idxMin 보다 크거나 같다
            // bs 에 값이 없는 경우 항상 값보다 큰 값 중 최소값을 리턴함
            // maxIdx 의 경우 큰 값을 포함하지 말아야 해서 인덱스를 줄여줌
            if (idxMax >= arr.length || arr[idxMax] != max) {
                idxMax--;
            }

            int answer = idxMax - idxMin + 1; // 사이에 있는 값
            System.out.println(answer);
        }
    }

    static int binarySearch(int number, int[] arr) {
        if (number > arr[arr.length - 1])
            return arr.length;
        else if (number <= arr[0])
            return 0;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > number) right = mid - 1;
            else if (arr[mid] < number) left = mid + 1;
            else return mid;
        }
        return left;
    }
}
