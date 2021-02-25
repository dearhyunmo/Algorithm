package Q_16956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_16956 {
	static int R, C, failCnt;
	static char[][] map;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R+1][C+1]; // 늑대와 양의 위치
		visit = new int[R+1][C+1]; // 방문여부 체크

		for (int i = 0; i < R; i++) { // 입력받기용 반복문
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '.')
					map[i][j] = 'D';
				else
					map[i][j] = str.charAt(j); // 양과 늑대 받기
			}
		}
		
		int result = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				test(i, j, 0); // 함수 ㄱㄱ
				if (failCnt == 1) { // failcnt가 1이면 탈락
					result = 0; // 결과는 실패
					break;
				}
			}
		}

		System.out.println(result); //결과 출력
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]); // 출력
			}
			System.out.println("");
		}
	}

	public static void test(int r, int c, int visited) {
		int[] dx = new int[] { -1, 0, 1, 0 }; // 사방탐색
		int[] dy = new int[] { 0, -1, 0, 1 }; // 사방탐색

//		System.out.println("메소드 : " + r + ", " + c);

		if (r < 0 || c < 0 || r > R || c > C) // 넘어가면 탈락
			return;

		if (visit[r][c] == 1) // 방문했던거면 탈락
			return;
		
		if(failCnt==1) // 실패한거면 탈락
			return;

//		System.out.println("메소드 : " + r + ", " + c);
		visit[r][c] = 1; // 방문한거 체크

		if (map[r][c] == 'W') { // W일때 확인
//			System.out.println("w도착테스트");
//			System.out.println(visited);
			if (visited == 1) { // S갔다온거면 실패
				failCnt = 1;
			}else {
				visit[r][c] = 0; // 다음 반복문 돌때 방문여부 안겹치게 0
			}
		}

		if (map[r][c] == 'S') { // S일때
//			System.out.println("S출발테스트");
//			System.out.println(visited);
			for (int i = 0; i < 4; i++) {
				int goX = r + dx[i]; // 방향 지정
				int goY = c + dy[i];

				test(goX, goY, visit[r][c]); // 이어서 ㄱㄱ
			}
		}

	}
}
