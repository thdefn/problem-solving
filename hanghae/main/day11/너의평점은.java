package hanghae.main.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 1. 입력 : 과목명 학점 등급 -> 20라인
 *
 * 2.
 * 2-1. P 인 경우 제외하고, (학점 × 과목평점) 계산
 * 2-2. P 인 경우 제외하고, 학점 더하기
 *
 * 3. 출력 : 계산결과
 */
// 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값
public class 너의평점은 {
    static Map<String, Double> scores = Map.of(
            "A+", 4.5, "A0", 4.0, "B+", 3.5, "B0", 3.0,
            "C+", 2.5, "C0", 2.0, "D+", 1.5, "D0", 1.0,
            "F", 0.0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int sumOfCredit = 0;
        double sumOfScore = 0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String subject = st.nextToken();
            double credit = (int) Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if ("P".equals(grade)) continue;
            sumOfCredit += credit;
            double score = scores.get(grade) * credit;
            sumOfScore += score;
        }

        double gpa = sumOfScore / sumOfCredit;
        System.out.printf("%.6f", gpa);

    }
}
