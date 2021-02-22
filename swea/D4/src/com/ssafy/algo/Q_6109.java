package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_6109 {
	static class Point {
		int row, col, ret;

		public Point(int row, int col, int ret) {
			this.row = row;
			this.col = col;
			this.ret = ret;
		}
	}

	static int[][] map;
	static String command;
	static int N;

	static void up() {
		Queue<Point> q = new LinkedList<Point>(); // 값이 있는 좌표를 담을 큐
		for (int i = 0; i < N; i++) { // col 이동
			int depth = 0; // 좌표 이동용
			for (int j = 0; j < N; j++) {// row 이동
				if (map[j][i] != 0) { // 값이 있는 경우
					q.offer(new Point(j, i, map[j][i])); // 큐에 담는다.
					map[j][i] = 0; // 초기화
				}
			}
			while (!q.isEmpty()) { // 큐가 빌때까지
				Point point = new Point(q.peek().row, q.peek().col, q.poll().ret);
				if (!q.isEmpty() && point.ret == q.peek().ret) { // 연속된 두수의 값이 같은 경우
					map[depth][i] = point.ret + q.poll().ret; // 값을 더한다.
					depth++; // 좌표 이동
				} else {// 값이 다른 경우
					map[depth][i] = point.ret;
					depth++;
				}
			}
		}
	}

	static void down() {
		Queue<Point> q = new LinkedList<Point>(); // 값이 있는 좌표를 담을 큐
		for (int i = 0; i < N; i++) { // col 이동
			int depth = N - 1; // 좌표 이동용
			for (int j = N - 1; j >= 0; j--) {// row 이동
				if (map[j][i] != 0) { // 값이 있는 경우
					q.offer(new Point(j, i, map[j][i])); // 큐에 담는다.
					map[j][i] = 0; // 초기화
				}
			}
			while (!q.isEmpty()) { // 큐가 빌때까지
				Point point = new Point(q.peek().row, q.peek().col, q.poll().ret);
				if (!q.isEmpty() && point.ret == q.peek().ret) { // 연속된 두수의 값이 같은 경우
					map[depth][i] = point.ret + q.poll().ret; // 값을 더한다.
					depth--; // 좌표 이동
				} else {// 값이 다른 경우
					map[depth][i] = point.ret;
					depth--;
				}
			}
		}
	}

	static void right() {
		Queue<Point> q = new LinkedList<Point>(); // 값이 있는 좌표를 담을 큐
		for (int i = 0; i < N; i++) { // row 이동
			int depth = N - 1; // 좌표 이동용
			for (int j = N - 1; j >= 0; j--) {// col 이동
				if (map[i][j] != 0) { // 값이 있는 경우
					q.offer(new Point(i, j, map[i][j])); // 큐에 담는다.
					map[i][j] = 0; // 초기화
				}
			}
			while (!q.isEmpty()) { // 큐가 빌때까지
				Point point = new Point(q.peek().row, q.peek().col, q.poll().ret);
				if (!q.isEmpty() && point.ret == q.peek().ret) { // 연속된 두수의 값이 같은 경우
					map[i][depth] = point.ret + q.poll().ret; // 값을 더한다.
					depth--; // 좌표 이동
				} else {// 값이 다른 경우
					map[i][depth] = point.ret;
					depth--;
				}
			}
		}
	}

	static void left() {
		Queue<Point> q = new LinkedList<Point>(); // 값이 있는 좌표를 담을 큐
		for (int i = 0; i < N; i++) { // row이동
			int depth = 0; // 좌표 이동용
			for (int j = 0; j < N; j++) {// col 이동
				if (map[i][j] != 0) { // 값이 있는 경우
					q.offer(new Point(i, j, map[i][j])); // 큐에 담는다.
					map[i][j] = 0; // 초기화
				}
			}
			while (!q.isEmpty()) { // 큐가 빌때까지
				Point point = new Point(q.peek().row, q.peek().col, q.poll().ret);
				if (!q.isEmpty() && point.ret == q.peek().ret) { // 연속된 두수의 값이 같은 경우
					map[i][depth] = point.ret + q.poll().ret; // 값을 더한다.
					depth++; // 좌표 이동
				} else {// 값이 다른 경우
					map[i][depth] = point.ret;
					depth++;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			command = st.nextToken();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} 
			switch (command) {
			case "up":
				up();
				break;
			case "down":
				down();
				break;
			case "left":
				left();
				break;
			case "right":
				right();
				break;
			}
				
			sb.append("#" + test + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
