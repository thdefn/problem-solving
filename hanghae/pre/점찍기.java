package hanghae.pre;

public class 점찍기 {
    public static void main(String[] args) {
        System.out.println(solution(1, 5));
    }

    public static long solution(int k, int d) {
        long answer = 0;
        int a = 0;
        while (a * k <= d) {
            int x = a * k;
            answer += yCount(maxYDistance(x, d), k);
            a++;
        }

        return answer;
    }

    public static int maxYDistance(int x, int d) {
        long xx = (long) Math.pow(x, 2);
        long dd = (long) Math.pow(d, 2);
        return (int)(Math.sqrt(dd-xx));
    }

    public static int yCount(int dist, int k) {
        return (dist / k) + 1;
    }
}
