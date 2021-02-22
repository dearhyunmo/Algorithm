package gold5;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_11559 {

	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	static int N = 12;
	static int M = 6;
	static char map[][];
	static boolean check[][];
	static Queue<Pos> queue;
	static Queue<Pos> count_queue;

	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static int count(char alpha) {
		Pos cur_pos;
		while (!queue.isEmpty()) {
			cur_pos = queue.poll();
			count_queue.offer(cur_pos);

			for (int i = 0; i < 4; i++) {
				Pos next_pos = new Pos(cur_pos.r + dr[i], cur_pos.c + dc[i]);
				// 동일한 색이면서 아직 방문하지 않았으면 큐에 삽입
				if (map[next_pos.r][next_pos.c] == alpha && !check[next_pos.r][next_pos.c]) {
					check[next_pos.r][next_pos.c] = true;
					queue.offer(next_pos);
				}
			}
		}

		// count_queue : 붙어있는 뿌요들의 모임
		return count_queue.size();
	}

	private static void deletePuyo(Pos pos) {
		for (int i = pos.r; i >= 1; i--)
			map[i][pos.c] = map[i - 1][pos.c];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int combo = 0;
		N = 12;
		M = 6;

		map = new char[N + 2][M + 2];
		check = new boolean[N + 2][M + 2];
		queue = new LinkedList<>();
		count_queue = new LinkedList<>();

		// 초기화 (테두리 설정)
		for (int i = 0; i < N + 2; i++)
			for (int j = 0; j < M + 2; j++)
				map[i][j] = '.';

		// 맵 설정
		for (int i = 1; i <= N; i++) {
			String line = sc.nextLine();
			for (int j = 1; j <= M; j++)
				map[i][j] = line.charAt(j - 1);
		}

		boolean isQuit = false;
		while (true) {
			isQuit = true;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					// 배열이 값이 알파벳이면서 아직 체크하지 않았다면 큐에 넣는다.
					if (Character.isAlphabetic(map[i][j]) && !check[i][j]) {
						check[i][j] = true;
						queue.offer(new Pos(i, j));

						// 붙어있는 동일한 색깔의 뿌요의 개수를 구한다.
						int num = count(map[i][j]);

						if (num >= 4) {
							for (int k = 0; k < num; k++) {
								Pos delete = count_queue.poll();
								map[delete.r][delete.c] = 'd';
							}
							// 하나라도 삭제할 게 있으면 while문이 끝나지 않는다.
							isQuit = false;
						}
						count_queue.clear();
					}
				}
			}

			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= M; j++) {
					if (map[i][j] == 'd')
						deletePuyo(new Pos(i, j));
					check[i][j] = false;
				}

			if (isQuit)
				break;

			++combo;
		}
		System.out.println(combo);
	}
}