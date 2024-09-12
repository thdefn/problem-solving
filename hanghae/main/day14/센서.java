package hanghae.main.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 16436 172
public class 센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);

        // 각 센서 사이의 distance 구하기
        Integer[] distance = new Integer[N];
        distance[0] = 0;
        for (int i = 1; i < N; i++) {
            distance[i] = sensors[i] - sensors[i - 1];
        }
        // distance 내림차순 sorting
        Arrays.sort(distance, (o1, o2) -> o2 - o1);
        // distance 큰 애들 K 개 빼줌
        long sum = 0;
        for (int i = K - 1; i < N; i++) {
            sum += distance[i];
        }

        System.out.println(sum);
    }
}
