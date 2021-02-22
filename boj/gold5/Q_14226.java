package gold5;


import java.io.*;
import java.util.*;

public class Q_14226 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 이모티콘 갯수
		int[][] d = new int[n + 1][n + 1]; // 
		for (int i = 0; i <= n; i++) {
			Arrays.fill(d[i], -1); // 다 -1로 초기화 (미방문)
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		q.add(0);
		d[1][0] = 0;
		while (!q.isEmpty()) { // q없을때까지 반복
			int s = q.remove(); // 화면 이모티콘 갯수
			int c = q.remove(); // 클립보드 이모티콘 갯수
			if (d[s][s] == -1) { // 방문 안했으면 클립보드 이모티콘을 모두 화면에 있는 이모티콘으로 변경
				d[s][s] = d[s][c] + 1;
				q.add(s);
				q.add(s);
			}
			if (s + c <= n && d[s + c][c] == -1) { // 아래도 s랑 c 순으로 
				d[s + c][c] = d[s][c] + 1;
				q.add(s + c);
				q.add(c);
			}
			if (s - 1 >= 0 && d[s - 1][c] == -1) {
				d[s - 1][c] = d[s][c] + 1;
				q.add(s - 1);
				q.add(c);
			}
		}
		
		int ans = -1;
		for (int i = 0; i <= n; i++) { // n만큼
			if (d[n][i] != -1) {  // 최솟값 구해주기
				if (ans == -1 || ans > d[n][i]) {
					ans = d[n][i]; //저장
				}
			}
		}
		System.out.println(ans);
	}
}