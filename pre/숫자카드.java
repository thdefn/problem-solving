package pre;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 숫자카드 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        Set<Integer> arrADivisorSet = getCommonDivisor(arrayA);
        Set<Integer> arrBDivisorSet = getCommonDivisor(arrayB);


        return Math.max(getMaxNotDividedDivisor(arrADivisorSet, arrayB)
                , getMaxNotDividedDivisor(arrBDivisorSet, arrayA));
    }

    public static int getMaxNotDividedDivisor(Set<Integer> divisorSet, int[] array) {
        int max = 0;
        for (int n : divisorSet) {
            boolean detected = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i] % n == 0) {
                    detected = true;
                    break;
                }
            }
            if (!detected) max = Math.max(max, n);
        }
        return max;
    }

    public static Set<Integer> getCommonDivisor(int[] arr) {
        Set<Integer> divisorSet = new HashSet<>();
        for (int i = 1; i * i <= arr[0]; i++) {
            if (arr[0] % i == 0) {
                divisorSet.add(i);
                if (i != arr[0] / i) {
                    divisorSet.add(arr[0] / i);
                }
            }
        }
        divisorSet.remove(1);
        for (int i = 1; i < arr.length; i++) {
            List<Integer> deleted = new ArrayList<>();
            for (int number : divisorSet) {
                if (arr[i] % number != 0)
                    deleted.add(number);
            }
            deleted.forEach(divisorSet::remove);
        }
        return divisorSet;
    }

}
