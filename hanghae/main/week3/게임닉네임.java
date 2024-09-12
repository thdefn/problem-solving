package hanghae.main.week3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 1. 입력 : 가입한 유저 수 N / 유저의 닉네임
 * <p>
 * - 별칭은 유저 닉네임의 접두사(Prefix) 중에서 가장 길이가 짧은 것
 * - 접두사가 이전에 가입한 닉네임의 접두사가 아니어야 한다
 * - 가능한 별칭이 없는 경우에는 유저가 가입한 시점까지 같은 닉네임으로 가입한 사람의 수 x를 계산
 * 3. 출력 : 별칭
 */
public class 게임닉네임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, Integer> nicknameCountMap = new HashMap<>();
        while (N-- > 0) {
            String nickname = sc.next();

            // 1. 이전에 가입한 닉네임이라면, 바로 아이디 도출
            StringBuilder sb = new StringBuilder(nickname);
            String id = nickname;
            if (nicknameCountMap.getOrDefault(nickname, 0) > 0) {
                int x = nicknameCountMap.get(nickname) + 1;
                nicknameCountMap.put(nickname, x);
                sb.append(x);
                id = sb.toString();
            } else {
                nicknameCountMap.put(nickname, 1);
                for (int i = nickname.length() - 1; i >= 1; i--) {
                    // 마지막 문자열 삭제
                    sb.deleteCharAt(i);
                    String prefix = sb.toString();
                    // 맵이 포함하고 있지 않다면 아이디로 기록
                    if (!nicknameCountMap.containsKey(prefix)) {
                        id = prefix;
                        nicknameCountMap.put(prefix, 0);
                    }
                }
            }

            System.out.println(id);

        }
    }
}
