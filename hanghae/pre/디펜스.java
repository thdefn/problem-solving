package hanghae.pre;

import java.util.Arrays;

public class 디펜스 {
    public static void main(String[] args) {
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        int n = 7;
        int k = 3;
        System.out.println(solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        int left = 0;
        int right = enemy.length - 1;
        int answer = 0;
        while (left <= right){
            int mid = (left + right) / 2 ;
            if(parametricSearch(enemy.clone(), mid, k, n)){ // true 라면 인덱스가 늘어나야 함
                answer = mid;
                left = mid + 1;
            } else { // false 라면 인덱스가 작아져야 함
                right = mid - 1;
            }
        }
        return answer + 1;
    }

    public static boolean parametricSearch(int[] enemy, int idx, int k, int n) {
        Arrays.sort(enemy, 0, idx + 1);
        for (int i = idx; i >= 0; i--) {
            if (k > 0) k--;
            else if(n >= enemy[i]) n = n - enemy[i];
            else return false;
        }
        return true;
    }

}
