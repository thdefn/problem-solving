package main.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

// 3 32
public class 소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int S = Integer.parseInt(br.readLine());

        int idx = 0;
        while (idx < arr.length - 1 && S > 0) {
            if (arr[idx] < arr[idx + 1]) {
                swap(arr, idx, idx + 1);
                S--;
            }
            idx++;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < arr.length; i++) {
            sj.add(String.valueOf(arr[i]));
        }
        System.out.println(sj);

        idx = arr.length - 1;
        while (S > 0 && idx > 0) {
            if (arr[idx] > arr[idx - 1]) {
                swap(arr, idx, idx - 1);
                S--;
            }
            idx--;
        }

       sj = new StringJoiner(" ");
        for (int i = 0; i < arr.length; i++) {
            sj.add(String.valueOf(arr[i]));
        }
        System.out.println(sj);
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
