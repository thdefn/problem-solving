package main.day9;

import java.io.*;
import java.util.*;

public class 삼에깃든힘2 {
    static List<Set<Integer>> graph = new ArrayList<>();
    static List<Set<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> nodes = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nodes.add(i);
            graph.add(new HashSet<>());
        }

        List<int[]> edges = new ArrayList<>();
        StringTokenizer st;
        while (N-- > 1) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u - 1).add(v - 1);
            graph.get(v - 1).add(u - 1);
            edges.add(new int[]{u - 1, v - 1});
        }

        divide(nodes, edges, graph.size() / 3);

        StringJoiner sj = new StringJoiner("\n");
        if (answer.isEmpty()) {
            sj.add("U");
        } else sj.add("S");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Set<Integer> tree : answer) {
            StringJoiner joiner = new StringJoiner(" ");
            for (int i : tree) {
                joiner.add(String.valueOf(i + 1));
            }
            sj.add(joiner.toString());
        }
        bw.write(sj.toString());
        bw.flush();
        bw.close();
    }


    static void divide(Set<Integer> nodes, List<int[]> edges, int depth) {
        if (depth == 0) {
            return;
        }
        if (nodes.size() == 3) {
            answer.add(nodes);
            return;
        }
        boolean found = false;
        for (int i = 0; i < edges.size(); i++) {
            int[] e = edges.get(i);
            int n1 = e[0];
            int n2 = e[1];
            Set<Integer> tree = new HashSet<>();
            Queue<Integer> nodeQueue = new LinkedList<>();
            nodeQueue.add(n1);
            while (!nodeQueue.isEmpty() && tree.size() < 3) {
                int node = nodeQueue.poll();
                tree.add(node);
                for (int otherNode : graph.get(node)) {
                    if (otherNode == n2 || tree.contains(otherNode))
                        continue;
                    if (nodes.contains(otherNode))
                        nodeQueue.add(otherNode);
                }
            }
            if (nodeQueue.isEmpty() && tree.size() == 3) {
                found = true;
                answer.add(tree);
                nodes.removeAll(tree);
                edges.subList(i + 1, edges.size());
                break;
            }
        }
        if (found) {
            divide(nodes, edges, depth - 1);
        }
    }
}
