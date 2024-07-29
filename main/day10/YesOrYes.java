package main.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class YesOrYes {
    static List<Set<Integer>> graph;
    static Set<Integer> fans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        int M = Integer.parseInt(st.nextToken());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u - 1).add(v - 1);
        }

        int S = Integer.parseInt(br.readLine());
        fans = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        while (S-- > 0) {
            fans.add(Integer.parseInt(st.nextToken()) - 1);
        }

        if (dfs(0, new HashSet<>()))
            System.out.println("Yes");
        else System.out.println("yes");
    }

    static boolean dfs(int node, Set<Integer> path) {
        if (fans.contains(node)) {
            return true;
        }

        // 지금까지 모든 경로에 팬이 없고, 경로의 끝이라면 false 를 출력함
        // 팬이 없는 path 가 발견되면 탐색 종료
        path.add(node);
        boolean hasFan = false;
        for (int neighbor : graph.get(node)) {
            if (path.contains(neighbor)) continue;
            if (dfs(neighbor, path)) {
                hasFan = true;
            } else {
                hasFan = false;
                break;
            }
        }
        return hasFan;
    }
}
