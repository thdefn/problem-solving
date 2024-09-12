package hanghae.pre;

import java.util.*;

public class 택배배달 {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        double y= 3.5;
        System.out.println(y * 6 + 65);

    }
    // 1 1 4 5 7
    // 0 3 3 7 7
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        Map<Integer, List<Integer>> deliveryHomeMap = new HashMap<>();
        Map<Integer, List<Integer>> pickupHomeMap = new HashMap<>();
        return answer;
    }

    public static void deliver(int[] deliveries, int[] pickups, int cap){
        if(Arrays.stream(deliveries).sum() == 0
                && Arrays.stream(pickups).sum() == 0)
            return;
    }
}
