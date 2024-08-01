package main.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 65536 420
public class 임시반장정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] classAssignment = new int[N][5];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                classAssignment[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 클래스 별로 학생을 기록함
        // 고유 넘버로 학년 반영
        Map<Integer, Set<Integer>> classStudentMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                int classNo = j * 10 + classAssignment[i][j];
                classStudentMap.putIfAbsent(classNo, new HashSet<>());
                Set<Integer> studentSet = classStudentMap.get(classNo);
                studentSet.add(i);
            }
        }

        // 위에서 구한 classStudentMap 을 통해 각 학생 별로 동급생을 구함
        int president = 0;
        int maxSumOfSchoolMate = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> classmateSet = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                int classNo = j * 10 + classAssignment[i][j];
                classmateSet.addAll(classStudentMap.get(classNo));
            }
            if (classmateSet.size() > maxSumOfSchoolMate) {
                maxSumOfSchoolMate = classmateSet.size();
                president = i;
            }
        }

        System.out.println(president + 1);


    }
}
