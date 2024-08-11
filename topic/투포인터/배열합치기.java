package topic.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열합치기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int[] res = new int[N + M];
        int idx = 0;
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                res[idx] = A[i];
                i++;
            } else {
                res[idx] = B[j];
                j++;
            }
            idx++;
        }

        while (i < A.length) {
            res[idx++] = A[i++];
        }

        while (j < B.length) {
            res[idx++] = B[j++];
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < res.length; k++) {
            sb.append(res[k]).append(" ");
        }
        System.out.println(sb);
    }
}
