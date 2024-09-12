package hanghae.pre;

public class 디펜스게임 {
    public static void main(String[] args) {
        int[] enemy = {3, 3, 3, 3};
        int n = 2;
        int k = 4;
        System.out.println(solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        return doDefenceGame(enemy, k, n, 0);
    }

    // return round
    public static int doDefenceGame(int[] enemy, int k, int n, int idx) {
        if (idx == enemy.length)
            return idx;
        else if (enemy[idx] > n && k < 1) {
            return idx;
        }

        // 이번에 무적권을 쓴다.
        int doChance = Integer.MIN_VALUE;
        int doFight = Integer.MIN_VALUE;
        if(k > 0){
            doChance = doDefenceGame(enemy, k - 1, n, idx + 1);
        }
        // 병사를 쓴다.
        if(n >= enemy[idx]){
            doFight = doDefenceGame(enemy, k, n - enemy[idx], idx + 1);
        }

        return Math.max(doChance, doFight);

    }

}
