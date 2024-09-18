package columbus.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 단절점과단절선 {
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int edgeSize = N - 1;
        while (edgeSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a - 1].add(b - 1);
            graph[b - 1].add(a - 1);
        }

        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (t == 1 && graph[k - 1].size() > 1) {
                System.out.println("yes");
            } else if (t == 2) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
