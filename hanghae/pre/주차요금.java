package hanghae.pre;

import java.util.*;

public class 주차요금 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
        };
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        // 1. 누적 주차 시간 구하기
        Map<String, String> numberRecordMap = new HashMap<>();
        Map<Integer, Integer> numberTimeSumMap = new TreeMap<>();
        for (String r : records) {
            String[] log = r.split(" ");
            if (log[2].equals("IN")) {
                numberRecordMap.put(log[1], log[0]); // 5961,05:34
            } else { // OUT 에 대한 레코드라면
                // 1. 주차시간 계산 및 누적시간 계산
                int du = calcTimeDuration(numberRecordMap.get(log[1]), log[0]);
                int carNumber = Integer.parseInt(log[1]);
                numberTimeSumMap.put(carNumber, numberTimeSumMap.getOrDefault(carNumber, 0) + du);
                // 2. numberRecordMap 에서 IN 기록 삭제
                numberRecordMap.remove(log[1]);
            }
        }

        // 2. OUT 기록이 없는 레코드에 대한 처리
        for (String k : numberRecordMap.keySet()){
            int du = calcTimeDuration(numberRecordMap.get(k), "23:59");
            int carNumber = Integer.parseInt(k);
            numberTimeSumMap.put(carNumber, numberTimeSumMap.getOrDefault(carNumber, 0) + du);
        }


        // 요금 정산
        int[] answer = new int[numberTimeSumMap.keySet().size()];
        int idx = 0;
        for (int k : numberTimeSumMap.keySet()){
            int totalDu = numberTimeSumMap.get(k);
           // System.out.println(k + "" + totalDu);
            int overDu = totalDu - fees[0];
            int subCharge = 0;
            if(overDu > 0){
                subCharge = (int) (Math.ceil((double) overDu / fees[2]) * fees[3]);
            }
            answer[idx++] = fees[1] + subCharge;
        }

        return answer;
    }

    public static int calcTimeDuration(String a, String b) {
        return timeToNumber(b) - timeToNumber(a);
    }

    public static int timeToNumber(String a) {
        String[] time = a.split(":");
        return Integer.parseInt(time[1]) + Integer.parseInt(time[0]) * 60;
    }
}
