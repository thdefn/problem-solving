package main.day14;

import java.util.Scanner;
// 17712 176
public class 거스름돈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 5원을 가능한 최대 개수로 세팅
        // 5원과 2원으로 거스름돈 구할 수 있는지 확인 -> 구할 수 있다면 break
        // 구하지 못한다면 5원 개수 줄여보기
        int count = -1;
        int maxFiveCoinCount = n / 5;
        for (int i = maxFiveCoinCount; i >= 0; i--) {
            int price = i * 5;
            int remainPrice = n - price;
            if (remainPrice % 2 == 0) {
                count = i + (remainPrice / 2);
                break;
            }
        }

        System.out.println(count);

    }
}
