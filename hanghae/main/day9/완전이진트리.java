package hanghae.main.day9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 15712 208
public class 완전이진트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int size = (int) (Math.pow(2, K) - 1);
        int[] tree = new int[size];
        for (int i = 0; i < size; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> nodes = new ArrayDeque<>();
        int rootIdx = tree.length / 2;
        nodes.add(rootIdx);
        int len = tree.length;
        for (int i = 0; i < K; i++) {
            int k = nodes.size();
            len = len / 2;
            int step = (len + 1) / 2;
            while (k-- > 0) {
                rootIdx = nodes.poll();
                nodes.add(rootIdx - step);
                nodes.add((rootIdx + step));
                System.out.print(tree[rootIdx] + " ");
            }
            System.out.println();
        }


    }
}
