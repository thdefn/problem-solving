package pre;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


//x - 1 , y  - 1
//x - 2, y
//x - 1, y
//x , y - 2
//x , y - 1

public class 거리두기 {
    public static void main(String[] args) {
        String[][] places = {
                {"PPOOO", "OOXPO", "OOOOO", "OOOOO", "OOOOO"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPO", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int answered = 0;
        for (String[] p : places) {
            Set<String> seated = new HashSet<>();
            answer[answered] = 1;
            for (int y = 0; y < p.length; y++) {
                String s = p[y];
                for (int x = 0; x < s.length(); x++) {
                    if (s.charAt(x) != 'P') continue;

                    if (seated.contains((x - 1) + "," + (y - 1)) && (p[y].charAt(x - 1) != 'X' || p[y - 1].charAt(x) != 'X')) {
                        answer[answered] = 0;
                        break;
                    }
                    if (seated.contains((x + 1) + "," + (y - 1)) && (p[y].charAt(x + 1) != 'X' || p[y - 1].charAt(x) != 'X')) {
                        answer[answered] = 0;
                        break;
                    }
                    else if (seated.contains((x) + "," + (y - 1))) {
                        answer[answered] = 0;
                        break;
                    } else if (seated.contains((x - 1) + "," + (y))) {
                        answer[answered] = 0;
                        break;
                    } else if (seated.contains((x - 2) + "," + (y)) && p[y].charAt(x - 1) != 'X') {
                        answer[answered] = 0;
                        break;
                    } else if (seated.contains(x + "," + (y - 2)) && p[y - 1].charAt(x) != 'X') {
                        answer[answered] = 0;
                        break;
                    }
                    seated.add(x + "," + y);
                }
                if(answer[answered] == 0) break;
            }
            answered++;
        }
        return answer;
    }


}
