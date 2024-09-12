package hanghae.pre;

import java.util.HashMap;
import java.util.List;

public class 모음사전 {
    static int idx = 1;
    static List<String> alpha = List.of("A", "E", "I", "O", "U");
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));

    }

    public static int solution(String word) {
        dfs(0, "");
        return map.get(word);
    }

    public static void dfs(int depth, String cur){
        if(depth == 5) return;

        for (int i = 0; i < 5; i++) {
            String next = cur + alpha.get(i);
            map.put(next, idx++);
            dfs(depth + 1, next);
        }
    }

}
