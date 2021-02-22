package gold5;


import java.io.*;
import java.util.*;

class Monkey {
	int row, col, jump, cnt;

	public Monkey(int row, int col, int jump, int cnt) {
		this.row = row;
		this.col = col;
		this.jump = jump;
		this.cnt = cnt;
	}
}

public class Q_1600 {

	static int[] dx = { -1, 0, 1, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { 0, 1, 0, -1, 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[][] map;
	static boolean[][][] visit;
	static int N, R, C, ans;
	static Queue<Monkey> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[N + 1][R][C];
		q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (0 == R - 1 && 0 == C - 1) {
			System.out.println(0);
			return;
		}
		System.out.println(bfs());
	}

	private static int bfs() {
		q.add(new Monkey(0, 0, N, 0));
		visit[N][0][0] = true;
		while (!q.isEmpty()) {
			Monkey monkey = q.poll();
			for (int i = 0; i < 12; i++) {
				if (i >= 4 && monkey.jump == 0)
					break;
				int nx = monkey.row + dx[i];
				int ny = monkey.col + dy[i];
				if (check(nx, ny) || map[nx][ny] == 1)
					continue;
				int jump = (i >= 4) ? monkey.jump - 1 : monkey.jump;
				if (visit[jump][nx][ny])
					continue;
				visit[jump][nx][ny] = true;
				if (nx == R - 1 && ny == C - 1) {
					return monkey.cnt + 1;
				}
				q.add(new Monkey(nx, ny, jump, monkey.cnt + 1));
			}
		}
		return -1;
	}

	private static boolean check(int nx, int ny) {
		return nx < 0 || nx >= R || ny < 0 || ny >= C;
	}
}
