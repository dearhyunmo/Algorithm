package gold5;


import java.util.Scanner;

public class Q_14499 {
	static int[] dice = new int[7]; // 주사위의 배열
	static int[][] map = new int[20][20]; // 지도의 배열
	static int[] dx = { 1, -1, 0, 0 }; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	static int[] dy = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt(); // 지도 세로 크기
		int m = sc.nextInt(); // 지도 가로 크기
		int y = sc.nextInt(); // 주사위 좌표
		int x = sc.nextInt(); 
		int k = sc.nextInt(); // 명령 갯수

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt(); // 지도 각 칸에 쓰여져 있는 수
			}
		}

		for (int i = 0; i < k; i++) { 
			int d = sc.nextInt(); // 동서남북 이동 방향
			int nx = dx[d - 1] + x; 
			int ny = dy[d - 1] + y;

			if (0 <= nx && nx < m && 0 <= ny && ny < n) { // 지도를 벗어나지 않을 때
				changeDice(d); // 주사위 굴리기

				if (map[ny][nx] == 0) {
					map[ny][nx] = dice[6];
				} else {
					dice[6] = map[ny][nx];
					map[ny][nx] = 0;
				}

				x = nx;
				y = ny;
				sb.append(dice[1] + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void changeDice(int d) {
		int[] temp = dice.clone();
		if (d == 1) { // 동
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		} else if (d == 2) { // 서
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if (d == 3) { // 북
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else { // 남
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
	}

}
