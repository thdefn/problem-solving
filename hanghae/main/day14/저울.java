package hanghae.main.day14;

import java.util.Arrays;
import java.util.Scanner;

public class 저울 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }

        Arrays.sort(weights);
        System.out.println(Arrays.toString(weights));
        int sum = Arrays.stream(weights).sum();
        System.out.println(sum);

    }

//    static boolean isPossible(){
//
//    }
}
