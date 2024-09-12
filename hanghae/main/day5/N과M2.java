package hanghae.main.day5;


import java.util.*;

public class N과M2 {
    static List<String> sequences = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        findSequence(new HashSet<>(), "", 1, N, M);
        for (String s : sequences) {
            System.out.println(s);
        }

    }

    public static void findSequence(Set<Integer> selected, String sequence, int startIdx, int endIdx, int M) {
        if (M == 0) {
            sequences.add(sequence);
            return;
        }

        // 1. selected 되지 않은 숫자라면, 이번 턴에 select 한다
        for (int i = startIdx; i <= endIdx; i++) {
            if (!selected.contains(i)) {
                // 1-1. selected 에 i 를 넣고, sequence 에도 i를 넣음
                // 1-2. select 시 다음에는 이번 인덱스 다음 인덱스부터 선택할 수 있다
                Set<Integer> next = new HashSet<>(selected);
                next.add(i);
                findSequence(next, sequence + i + " ", i + 1, endIdx, M - 1);
            }
        }

    }
}


