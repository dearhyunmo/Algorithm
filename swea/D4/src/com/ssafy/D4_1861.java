package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861 {

	static int[][] map;
	static int[][] dp;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n]; // 지도
			dp = new int[n][n]; // 이동하는 값 저장

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} 

			int max = Integer.MIN_VALUE;
			int start = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// dp배열의 값이 0일 때만 방문
					// 0이 아닌 경우는 이미 해당 방에서 갈 수 있는 최대값이 저장되어 있다.
					if (dp[i][j] == 0) {
						solve(i, j);
					}
					// 최대값 갱신

					if (max < dp[i][j]) {
						max = dp[i][j];
						start = map[i][j];
					} else if (max == dp[i][j]) {
						// 최대값이 같은 경우에는 start 숫자가 작은 값을 저장한다.
						start = start > map[i][j] ? map[i][j] : start;
					}
				}
			}
			System.out.println("#" + tc + " " + start + " " + max);
		}
	}
	static int[] dx = { -1, 1, 0, 0 }; //±1
	static int[] dy = { 0, 0, -1, 1 }; //±1

	public static void solve(int y, int x) {
		dp[y][x] = 1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny > n - 1 || nx < 0 || nx > n - 1)
				continue;
			if (map[ny][nx] == map[y][x] + 1) {
				// 아직 방문한 적이 없을때만 solve 함수를 호출한다.
				if (dp[ny][nx] == 0)
					solve(ny, nx);
				// 최대값으로 갱신한다.
				if (dp[y][x] < 1 + dp[ny][nx]) {
					dp[y][x] = 1 + dp[ny][nx];
				}
			}
		}
	}
}