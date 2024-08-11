package 기출;

import java.util.Arrays;

public class 택배배달과수거하기 {
    public static void main(String[] args) {
        int[] deliveries = {0, 0};
        int[] pickups = {0, 4};
        System.out.println(solution(2, 2, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long distance = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] <= 0 && pickups[i] <= 0)
                continue;
            int cnt = Math.max((deliveries[i] + cap - 1) / cap, (pickups[i] + cap - 1) / cap);
            distance += (2L * (i + 1) * cnt);
            int deliveryRemain = cap * cnt;
            int j = i;
            while (deliveryRemain > 0 && j >= 0) {
                if (deliveries[j] <= deliveryRemain) {
                    deliveryRemain -= deliveries[j];
                    deliveries[j] = 0;
                    j--;
                } else {
                    deliveries[j] -= deliveryRemain;
                    deliveryRemain = 0;
                }
            }

            int pickupRemain = cap * cnt;
            int k = i;
            while (pickupRemain > 0 && k >= 0) {
                if (pickups[k] <= pickupRemain) {
                    pickupRemain -= pickups[k];
                    pickups[k] = 0;
                    k--;
                } else {
                    pickups[k] -= pickupRemain;
                    pickupRemain = 0;
                }
            }

        }

        return distance;
    }
}
