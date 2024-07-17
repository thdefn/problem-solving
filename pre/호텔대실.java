package pre;

import java.util.Arrays;

public class 호텔대실 {
    public static void main(String[] args) {
        String[][] book_time = {
                {"10:20", "12:30"}, {"10:20", "12:30"},
                {"10:20", "12:30"}
        };
        System.out.println(solution(book_time));
    }
    public static int solution(String[][] book_time) {
        int[] count = new int[60 * 24 + 10];
        for (String[] record : book_time){
            int startTime = timeToIndex(record[0]);
            int endTime = timeToIndex(record[1]) + 9;
            for (int i = startTime; i <= endTime; i++)
                count[i]++;
        }

        int answer = 0;
        for (int i = 0; i < 60 * 24; i++) {
            answer = Math.max(count[i], answer);
        }
        return answer;
    }

    public static int timeToIndex(String time){
        String[] parsedTime = time.split(":");
        return Integer.parseInt(parsedTime[0]) * 60 + Integer.parseInt(parsedTime[1]);
    }
}
