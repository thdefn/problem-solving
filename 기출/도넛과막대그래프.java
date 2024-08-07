package 기출;

import java.util.*;

public class 도넛과막대그래프 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {4, 11}, {1, 12}, {8, 3}, {12, 7},
                {4, 2}, {7, 11}, {4, 8}, {9, 6},
                {10, 11}, {6, 10}, {3, 5}, {11, 1},
                {5, 3}, {11, 9}, {3, 8}
        };
        System.out.println(Arrays.toString(solution(edges)));
    }

    public static int[] solution(int[][] edges) {
        Map<Integer, Set<Integer>> outDegreeMap = new HashMap<>();
        Map<Integer, Integer> inDegreeCount = new HashMap<>();
        // outdegree 가 가장 많은 애가 후보 -> 최소 두개
        // indgree 가 0개 여야함
        for (int[] e : edges) {
            if (!outDegreeMap.containsKey(e[0])) {
                outDegreeMap.put(e[0], new HashSet<>());
            }
            Set<Integer> set = outDegreeMap.get(e[0]);
            set.add(e[1]);
            inDegreeCount.put(e[1], inDegreeCount.getOrDefault(e[1], 0) + 1);
        }

        int[] answer = new int[4];
        // indegree 가 0개인 노드 찾기 -> 생성한 정점
        for (int node : outDegreeMap.keySet()) {
            if (!inDegreeCount.containsKey(node) && outDegreeMap.get(node).size() > 1) {
                answer[0] = node;
                break;
            }
        }
        // 생성한 정점의 이웃 탐색
        // outdegree 가 두개면, 도넛그래프
        for (int node : outDegreeMap.get(answer[0])) {
            check(outDegreeMap, node, answer);
        }
        return answer;
    }

    static void check(Map<Integer, Set<Integer>> outDegreeMap, int start, int[] answer) {
        if (!outDegreeMap.containsKey(start)) {
            answer[2]++;
            return;
        }
        Set<Integer> outDegreeSet = outDegreeMap.get(start);
        if (outDegreeSet.size() > 1) {
            answer[3]++;
            return;
        }
        int next = outDegreeSet.stream().findFirst().get();
        while (next != start) {
            if (!outDegreeMap.containsKey(next)) {
                answer[2]++;
                return;
            }
            outDegreeSet = outDegreeMap.get(next);
            if (outDegreeSet.size() > 1) {
                answer[3]++;
                return;
            }
            next = outDegreeSet.stream().findFirst().get();
        }
        answer[1]++;
    }
}
