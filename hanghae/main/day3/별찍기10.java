package hanghae.main.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 별찍기10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (String s : drawPattern(N)){
            System.out.println(s);
        }
    }

    public static List<String> drawPattern(int N) {
        if (N == 1) {
            return List.of("*");
        }

        List<String> patterns = new ArrayList<>();
        int next = N / 3;
        List<String> innerPattern = drawPattern(next);
        for (int i = 0; i < next; i++) {
            patterns.add(innerPattern.get(i % next).repeat(3));
        }
        for (int i = 0; i < next; i++) {
            patterns.add(innerPattern.get(i % next) + " ".repeat(next) + innerPattern.get(i % next));
        }
        for (int i = 0; i < next; i++) {
            patterns.add(innerPattern.get(i % next).repeat(3));
        }
        return patterns;
    }
}
