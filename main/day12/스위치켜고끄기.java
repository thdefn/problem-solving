package main.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            if (gender == 1)
                changeMultipleIdx(idx, arr);
            else changeSymmetryIdx(idx, arr);
        }

        int lineBreakCnt = arr.length / 20 + 1;
        for (int i = 0; i < lineBreakCnt; i++) {
            int baseIdx = i * 20;
            for (int j = 0; j < 20; j++) {
                if (baseIdx + j >= arr.length) break;
                System.out.print(arr[baseIdx + j] + " ");
            }
            if(i < lineBreakCnt - 1) System.out.println();
        }

    }

    static void changeMultipleIdx(int idx, int[] arr) {
        int i = idx;
        while (i < arr.length) {
            arr[i] = 1 - arr[i];
            i += (idx + 1);
        }
    }

    static void changeSymmetryIdx(int idx, int[] arr) {
        arr[idx] = 1 - arr[idx];
        int i = 1;
        while (idx - i >= 0 && idx + i < arr.length) {
            if (arr[idx - i] == arr[idx + i]) {
                int changedValue = 1 - arr[idx - i];
                arr[idx - i] = changedValue;
                arr[idx + i] = changedValue;
            } else break;
            i++;
        }
    }
}
