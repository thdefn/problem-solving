package hanghae.pre;

import java.util.HashSet;
import java.util.Set;

public class 롤케이크 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 3, 1, 4};
        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        int answer = 0;
        int[] left = new int[topping.length];
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            numberSet.add(topping[i]);
            left[i] = numberSet.size();
        }

        int[] right = new int[topping.length + 1];
        numberSet.clear();
        for (int i = topping.length - 1; i >= 0; i--) {
            numberSet.add(topping[i]);
            right[i] = numberSet.size();
        }

        for (int i = 0; i < topping.length; i++) {
            if (left[i] == right[i + 1]){
                System.out.println(i);
                answer++;
            }
        }

        return answer;
    }


}
