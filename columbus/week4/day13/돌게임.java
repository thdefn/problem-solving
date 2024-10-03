package columbus.week4.day13;

import java.util.Scanner;

public class 돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        // 3으로 나뉘어지는 수
        int remainStone = N % 3;
        int turnCount = N / 3 + remainStone;
        if(turnCount % 2 == 0)
            System.out.println("CY");
        else System.out.println("SK");

    }
}
