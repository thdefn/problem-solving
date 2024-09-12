package columbus.day1;

import java.util.Scanner;

/**
 * 1. 입력 :
 * A - 한시간 일할 때 피로도 / B - 처리한 일 / C - 한시간 쉴때 피로도 감소량 / M - 피로도 한계
 * <p>
 * 3. 출력 :
 * 피로도가 M 이 넘지 않는 선에서 최대 처리량
 */
public class 피로도 {
    static int A;
    static int B;
    static int C;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();


        // 1. 일할 수 있는 시간은 0 - 24


        if (A <= M) {
            System.out.println(getMaxWork());
        } else {
            System.out.println(0);
        }


    }

    static long getMaxWork() {
        int l = 0;
        int r = 24;

        long maxWork = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            // 2-1. m만큼 일하는 게 가능하다.
            // 2-1-1. maxWork 을 갱신한다
            // 2-1-2. m이 증가하는 방향으로 조정한다.

            // 3-1. m만큼 일하는 게 불가능하다.
            // 3-1-1. m이 감소하는 방향으로 조정한다.
            if (isPossible(m)) {
                maxWork = m * (long) B;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return maxWork;
    }

    static boolean isPossible(int time) {
        // 1. time 만큼 일했을 때 피로도 계산
        int work = time;
        int rest = 24 - time;


        int tiredScore = 0;
        while (work-- > 0) {
            while (tiredScore >= M && rest-- > 0) {
                tiredScore -= C;
            }

            if (tiredScore >= M) return false;
            else if (tiredScore < 0) tiredScore = 0;

            tiredScore += A;
        }

        while (tiredScore > M && rest-- > 0) {
            tiredScore -= C;
        }

        if (tiredScore > M) return false;

        return true;
    }
}
