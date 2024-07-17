package main.day1;

import java.util.Scanner;

public class 이천칠년 {
    // 1. 각 달에 대한 날짜 수를 배열로 저장.
    // 연속된 데이터이고, 조회만 발생하므로 배열 사용함. input 데이터에 대한 처리를 쉽게 하기 위해 0월 추가
    static int[] daysOfMonth = new int[]
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // 2. 출력 형태 배열로 저장.
    // 0 이면 SUN, 1이면 MON ...
    static String[] dayOfWeek = new String[]
            {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();

        // 3. input 날짜를 일수로 변환함 ex) 1월 1일 -> 1일
        int cntOfDays = day;
        for (int i = 1; i < month; i++) {
            cntOfDays += daysOfMonth[i];
        }

        // 4. 일수로 변환한 날짜를 7로 나누기 연산함
        // MON 이면 1이 나오도록 함
        System.out.println(dayOfWeek[cntOfDays % 7]);
    }
}
