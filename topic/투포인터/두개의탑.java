package topic.투포인터;

import java.util.Arrays;
import java.util.Scanner;

// 1 2 3 4 5
//  1 2 3 4 5

// 1 3 6 10 15
public class 두개의탑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = sc.nextInt();
        }

        long sum = Arrays.stream(dist).sum();

        int i = 0;
        int j = 0;
        long prefixSum = dist[0];
        long maxDistance = 0;
        while (j < dist.length - 1) {
            if (prefixSum <= sum - prefixSum) {
                maxDistance = Math.max(maxDistance, prefixSum);
                j++;
                prefixSum += dist[j];
            } else {
                prefixSum -= dist[i];
                i++;
            }
        }

        while (prefixSum > sum - prefixSum && i < dist.length - 1) {
            prefixSum -= dist[i];
            i++;
        }

        if(prefixSum <= sum - prefixSum)
            maxDistance = Math.max(maxDistance, prefixSum);


        System.out.println(maxDistance);
    }
}
