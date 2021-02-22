package gold5;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_17144 {
	static int map[][];
	static boolean visited[][];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int R, C, T;
	static int cleanerCount = 0;
	static int[] cleanerX = new int[2];
	static int[] cleanerY = new int[2];
	static int totalDust;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		T = Integer.parseInt(input[2]);

		map = new int[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == -1) { // 공기청정기 위치
					cleanerX[cleanerCount] = i;
					cleanerY[cleanerCount] = j;
					cleanerCount++;
				}
			}
		}
		// diffusion 시작
		diffusion(0);
		System.out.println(totalDust);

	}

	static void diffusion(int t) {
		int[][] tmp_map = new int[R][C];
		int count = 0;
		// T초가 되면
		if (t == T) {
			totalDust = sumDust(); // 남아있는 먼지 더하기
			return;
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					for (int k = 0; k < 4; k++) {
						int x1 = i + dx[k];
						int y1 = j + dy[k];
						// tmp_map에 확산된 먼지들을 넣기
						if (x1 >= 0 && x1 < R && y1 >= 0 && y1 < C && map[x1][y1] != -1) {
							tmp_map[x1][y1] += map[i][j] / 5;
							count++;
						}
					}
					// 원래 map에서는 확산이 되었으므로 1/5씩 감소
					map[i][j] -= map[i][j] / 5 * count;
					count = 0;
				}
			}
		}
		sum(tmp_map); //map에 tmp_map을 더해주기
		startCleaner(); // 공기청정기 동작 시작
		diffusion(t + 1);
	}

	static void sum(int[][] tmp) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] += tmp[i][j];
			}
		}
	}

	static void startCleaner() { // 각 방향에 대한 먼지 이동
		for (int i = cleanerX[0] - 1; i >= 0; i--) {
			if (i != 0) {
				map[i][0] = map[i - 1][0];
			}
		}

		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}

		for (int i = 0; i < cleanerX[0]; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}

		for (int i = C - 1; i >= 1; i--) {
			map[cleanerX[0]][i] = map[cleanerX[0]][i - 1];

			if (i == 1) {
				map[cleanerX[0]][i] = 0;
			}
		}

		for (int i = cleanerX[1] + 1; i < R; i++) {
			if (i != R - 1) {
				map[i][0] = map[i + 1][0];
			}
		}

		for (int i = 0; i < C - 1; i++) {
			map[R - 1][i] = map[R - 1][i + 1];
		}

		for (int i = R - 1; i > cleanerX[1]; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}

		for (int i = C - 1; i >= 1; i--) {
			map[cleanerX[1]][i] = map[cleanerX[1]][i - 1];

			if (i == 1) {
				map[cleanerX[1]][i] = 0;
			}
		}
	}

	static int sumDust() { // 먼지 더하기
	        int total = 0;
	        
	        for(int i=0; i<R; i++) {
	            for(int j=0; j<C; j++) {
	                if(map[i][j] != -1) {
	                    total += map[i][j];
	                }
	            }
	        }
	        
	        return total;
	    }
}
