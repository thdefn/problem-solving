package main.day11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LCS3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        Set<String> subSequences = new HashSet<>();
        dfs("", 0, a.toCharArray(), subSequences);
        Set<String> remains = new HashSet<>();
        dfs("", 0, b.toCharArray(), remains);
        subSequences.retainAll(remains);
        remains = new HashSet<>();
        dfs("", 0, c.toCharArray(), remains);
        subSequences.retainAll(remains);

        int maxLength = 0;
        for (String s : remains)
            maxLength = Math.max(s.length(), maxLength);
        System.out.println(maxLength);

    }


    static void dfs(String s, int i, char[] chars, Set<String> subs) {
        if (i >= chars.length) {
            return;
        }
        // 0
        for (int j = i; j < chars.length; j++) {
            String str = s + chars[j];
            subs.add(str);
            dfs(str, j + 1, chars, subs);
        }
    }
}
