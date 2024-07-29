package main.day9;

import java.io.*;
import java.util.*;

public class 삼에깃든힘 {
    static List<Set<Integer>> gr = new ArrayList<>();
    static Set<Integer> nodeSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            nodeSet.add(i);
            gr.add(new HashSet<>());
        }

        List<int[]> edges = new ArrayList<>();
        StringTokenizer st;
        while (N-- > 1) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gr.get(u - 1).add(v - 1);
            gr.get(v - 1).add(u - 1);
            edges.add(new int[]{u - 1, v - 1});
        }

        List<String> answer = new ArrayList<>(N / 3 + 1);
        divide(edges, gr.size(), answer);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringJoiner sj = new StringJoiner("\n");
        if (answer.isEmpty()) {
            sj.add("U");
        } else sj.add("S");

        for (String str : answer) {
            sj.add(str);
        }
        bw.write(sj.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void divide(List<int[]> edges, int N, List<String> answer) {
        // N / 3 개의 트리를 만들어야 함
        int size = N / 3;
        int foundTree = 0;

        if (size == 1) {
            answer.add(treeToString(nodeSet));
            return;
        }

        int idx = 0; // 엣지 탐색용
        while (size > foundTree && idx < edges.size()) {
            int[] e = edges.get(idx++);
            Set<Integer> tree = new HashSet<>();
            dividedByNode(e[0], e[1], tree);
            if (tree.size() == 3) {
                answer.add(treeToString(tree));
                nodeSet.removeAll(tree);
                foundTree++;
            }

            tree = new HashSet<>();
            dividedByNode(e[1], e[0], tree);
            if (tree.size() == 3) {
                answer.add(treeToString(tree));
                nodeSet.removeAll(tree);
                foundTree++;
            }
        }
    }

    static String treeToString(Set<Integer> tree) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i : tree) {
            sj.add(String.valueOf(i + 1));
        }
        return sj.toString();
    }

    static void dividedByNode(int n1, int n2, Set<Integer> tree) {
        Queue<Integer> nodes = new ArrayDeque<>();
        nodes.add(n1);
        while (!nodes.isEmpty()) {
            int i = nodes.poll();
            tree.add(i);
            for (int node : nodeSet) {
                if (node == n2 || tree.contains(node))
                    continue;
                if (gr.get(i).contains(node)) {
                    nodes.add(node);
                }
            }
        }
    }


}
