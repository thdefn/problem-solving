package columbus.midterm;


import java.util.Scanner;

public class 일루미네이션 {
    // 홀수 행에 대한 6방향 이동 (oddDrdc)
    static int[][] oddDrdc = new int[][]{
            {1, 0}, {-1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, -1}
    };

    // 짝수 행에 대한 6방향 이동 (evenDrdc)
    static int[][] evenDrdc = new int[][]{
            {1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();  // 너비
        int H = sc.nextInt();  // 높이

        // 건물 배열 (존재 여부를 나타냄)
        boolean[][] exist = new boolean[H][W];

        // 지도 입력 받기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                exist[i][j] = (sc.nextInt() == 1);
            }
        }

        int len = 0;  // 외부 벽면 길이 합계
        for (int i = 0; i < H; i++) {
            int[][] drdc;
            if (i % 2 == 0) {
                drdc = oddDrdc;  // 짝수 행일 때의 이동 방향
            } else {
                drdc = evenDrdc;  // 홀수 행일 때의 이동 방향
            }

            for (int j = 0; j < W; j++) {
                // 건물이 있는 경우
                if (exist[i][j]) {
                    // 6방향 탐색
                    for (int[] d : drdc) {
                        int r = i + d[0];  // 이동한 행
                        int c = j + d[1];  // 이동한 열

                        // 지도 밖이거나, 건물이 없는 경우 벽면 추가
                        if (r < 0 || c < 0 || r >= H || c >= W || !exist[r][c]) {
                            len++;
                        }
                    }
                }
            }
        }

        System.out.println(len);  // 결과 출력
    }
}

