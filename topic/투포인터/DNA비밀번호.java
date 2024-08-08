package topic.투포인터;

import java.util.Map;
import java.util.Scanner;

public class DNA비밀번호 {
    static Map<Character, Integer> characterIndexMap = Map.of(
            'A', 0, 'C', 1, 'G', 2, 'T', 3);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int P = sc.nextInt();
        String dna = sc.next();
        int[] condition = new int[4];
        for (int i = 0; i < 4; i++) {
            condition[i] = sc.nextInt();
        }


        // 초기 P 까지의 카운팅
        int[] characterCnt = new int[4];
        for (int i = 0; i < P; i++) {
            int idx = characterIndexMap.get(dna.charAt(i));
            characterCnt[idx]++;
        }

        // 이후부터는 인덱스에 따라 characterCnt 갱신하면서 탐색
        // 다음 인덱스로 이동할때,
        // start 인덱스의 캐릭터 제외한다
        // end 인덱스의 캐릭터 추카한다
        int answer = 0;
        int lastStart = S - P;
        for (int i = 0; i < lastStart; i++) {
            if (isMeet(characterCnt, condition))
                answer++;
            int start = characterIndexMap.get(dna.charAt(i));
            characterCnt[start]--;
            int end = characterIndexMap.get(dna.charAt(i + P));
            characterCnt[end]++;
        }
        if (isMeet(characterCnt, condition))
            answer++;
        System.out.println(answer);

    }

    static boolean isMeet(int[] characterCnt, int[] condition) {
        if (characterCnt[0] < condition[0])
            return false;
        if (characterCnt[1] < condition[1])
            return false;
        if (characterCnt[2] < condition[2])
            return false;
        if (characterCnt[3] < condition[3])
            return false;
        return true;
    }
}
