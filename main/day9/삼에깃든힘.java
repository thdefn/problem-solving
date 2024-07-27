package main.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 삼에깃든힘 {
    static boolean[][] graph;
    static Set<Integer> selectedSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new boolean[N][N];
        List<int[]> edges = new ArrayList<>();
        while (N-- > 1) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u - 1][v - 1] = true;
            graph[v - 1][u - 1] = true;
            edges.add(new int[]{u - 1, v - 1});
            edges.add(new int[]{v - 1, u - 1});
        }

        divide(edges, graph.length);
    }

    static void divide(List<int[]> edges, int N) {
        // N / 3 - 1 개 간선 선택해야 함
        int size = N / 3;
        int foundedTree = 0;


        int idx = 0; // 엣지 탐색용
        while (size > foundedTree && idx < edges.size()) {
            int[] e = edges.get(idx++);
            Set<Integer> tree = dividedByNode(e[0], e[1]);
            if (tree.size() == 3) {
                System.out.println(tree);
                selectedSet.addAll(tree);
                foundedTree++;
            }
        }
    }

    static Set<Integer> dividedByNode(int n1, int n2) {
        Set<Integer> tree = new HashSet<>();
        Queue<Integer> nodes = new ArrayDeque<>();
        nodes.add(n1);
        while (!nodes.isEmpty()) {
            int i = nodes.poll();
            tree.add(i);
            for (int j = 0; j < graph.length; j++) {
                if (j == n2 || selectedSet.contains(j)) continue;
                if (!tree.contains(j) && graph[i][j]) {
                    nodes.add(j);
                }
            }
        }
        return tree;
    }

}
