package columbus.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 바이러스 {
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new boolean[N][N];
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a - 1][b - 1] = true;
            graph[b - 1][a - 1] = true;
        }

        Set<Integer> visitedSet = new HashSet<>();
        visit(0, visitedSet);
        System.out.println(visitedSet.size() - 1);
    }


    static void visit(int node, Set<Integer> visitedSet) {
        visitedSet.add(node);
        for (int i = 0; i < graph.length; i++) {
            if (graph[node][i] && !visitedSet.contains(i))
                visit(i, visitedSet);
        }
    }
}
