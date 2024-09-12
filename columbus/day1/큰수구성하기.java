package columbus.day1;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수구성하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sizeOfK = sc.nextInt();
        int[] K = new int[sizeOfK];
        for (int i = 0; i < sizeOfK; i++) {
            K[i] = sc.nextInt();
        }

        Arrays.sort(K);

        char[] numbers = String.valueOf(N).toCharArray();


        int index = 0;
        int[] indexOfMaxNumbers = new int[numbers.length];

        for (char ch : numbers) {
            int number = ch - '0';

            int i;
            for (i = K.length - 1; i >= 0; i--) {
                if (K[i] <= number) break;
            }

            i = Math.max(i, 0);
            if (K[i] <= number) indexOfMaxNumbers[index++] = i;
            else if (index > 0) {
                indexOfMaxNumbers[index - 1]--;
                break;
            } else indexOfMaxNumbers[index++] = -1;
            if (K[i] < number) break;
        }

        while (index < numbers.length) {
            indexOfMaxNumbers[index++] = K.length - 1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < indexOfMaxNumbers.length; i++) {
            if (indexOfMaxNumbers[i] < 0) continue;
            sb.append(K[indexOfMaxNumbers[i]]);
        }

        System.out.println(sb);

    }
}
