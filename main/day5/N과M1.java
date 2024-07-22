package main.day5;

import java.util.*;

public class N과M1 {
    static List<String> sequences = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        findSequence(new HashSet<>(), "", N, M);
        for (String s : sequences) {
            System.out.println(s);
        }

    }

    public static void findSequence(Set<Integer> selected, String sequence, int N, int M) {
        if (M == 0) {
            sequences.add(sequence);
            return;
        }

        // 1. selected 되지 않은 숫자라면, 이번 턴에 select 한다
        for (int i = 1; i <= N; i++) {
            if (!selected.contains(i)) {
                // 1-1. selected 에 i 를 넣고, sequence 에도 i를 넣음
                Set<Integer> next = new HashSet<>(selected);
                next.add(i);
                findSequence(next, sequence + i + " ", N, M - 1);
            }
        }

    }
}
