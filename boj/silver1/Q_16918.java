package Q_16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_16918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		int[][] map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray(); // 문장 읽은거 배열로 전환
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[j] == 'O' ? 3 : 0;// 터지기 까지 남은 시간
			}
		}
		for (int n = 2; n <= N; n++) {
			if (n % 2 == 1) { // 홀 수 일 때
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == n) {
							map[i][j] = 0;
							if (i > 0 && map[i - 1][j] != n)
								map[i - 1][j] = 0;
							if (j > 0 && map[i][j - 1] != n)
								map[i][j - 1] = 0;
							if (i < R - 1 && map[i + 1][j] != n)
								map[i + 1][j] = 0;
							if (j < C - 1 && map[i][j + 1] != n)
								map[i][j + 1] = 0;
						}
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						map[i][j] = map[i][j] == 0 ? n + 3 : map[i][j];
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j] > 0 ? 'O' : '.');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
