package main.day5;

import java.io.*;
import java.util.*;

// String 의 사전순과 수열의 사전순이 다름
public class N과M9 {
    static List<String> sequences = new ArrayList<>();
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 수열의 사전 순 증가를 위한 sorting
        Arrays.sort(nums);

        // 2. 재귀를 통해 가능한 수열 찾기
        findSequence(new HashSet<>(), "", M);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : sequences) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static void findSequence(Set<Integer> selected, String sequence, int M) {
        if (M == 0) {
            sequences.add(sequence);
            return;
        }

        int beforeNum = -1;
        for (int idx = 0; idx < nums.length; idx++) {
            // 1. 동일한 턴에 동일한 숫자가 선택되는 것을 방지함
            if (beforeNum == nums[idx]) continue;
            // 2. selected 되지 않은 숫자라면, 이번 턴에 select 한다
            if (!selected.contains(idx)) {
                // 2-2. selected 에 idx 를 넣고, sequence 에는 숫자 추가
                Set<Integer> next = new HashSet<>(selected);
                next.add(idx);
                beforeNum = nums[idx];
                findSequence(next, sequence + nums[idx] + " ", M - 1);
            }
        }

    }
}
