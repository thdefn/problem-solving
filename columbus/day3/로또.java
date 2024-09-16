package columbus.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        while (k > 0) {
            int[] S = new int[k];
            for (int i = 0; i < k; i++)
                S[i] = Integer.parseInt(st.nextToken());
            int selectRange = S.length - 5;
            for (int i = 0; i < selectRange; i++) {
                dfs(S, i + 1, String.valueOf(S[i]), 1);
            }

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            System.out.println();
        }
    }

    static void dfs(int[] S, int index, String answer, int selectedCount) {
        if (selectedCount == 6) {
            System.out.println(answer);
            return;
        }

        for (int i = index; i < S.length; i++) {
            dfs(S, i + 1, answer + " " + S[i], selectedCount + 1);
        }
    }

}
