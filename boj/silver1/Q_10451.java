package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_10451 {

	// TC
	
	// 1	2	3	4	5	6	7	8
	//	3	2	7	8	1	4	5	6
	
	// 1 → 3  → 7  → 5  →1
	// 2 → 2
	// 4 → 8 → 6 → 4
	
	static ArrayList<Integer>[] list; // Integer ArrayList
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케 갯수
		int size, cnt; // size = 순열 수 갯수 , cnt = 순열 사이클 갯수
		
		for (int i = 0; i < T; i++) { // 테케만큼 반복
			cnt = 0; // 테케별 순열 사이클 갯수 달라서 0 초기화
			size = Integer.parseInt(br.readLine()); // 순열 수 갯수 받아오기
			list = new ArrayList[size + 1]; //리스트 배열 사이즈 지정
			for (int j = 1; j <= size; j++) {
				list[j] = new ArrayList<Integer>();
			}
			check = new boolean[size + 1]; // 방문했는지 아닌지 체크용 boolean 배열

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 1; k <= size; k++) {
				int tmp = Integer.parseInt(st.nextToken()); 
				
				list[k].add(tmp); // 리스트에 수 넣어주기
			}
			for (int j = 1; j <= size; j++) { // 
				if (!check[j]) { // 방문 안했으면 dfs 돌리게 들어감
					System.out.println("====="+cnt+"====");
					dfs(j); // dfs
					cnt++; // 사이클 몇개인지
				}
			}
			System.out.println(cnt); // 출력

		}

	}

	public static void dfs(int i) { // 시작하는 지점 i
		System.out.println(i);
		if (check[i]) { // 방문했으면
			return; // 끝
		}
		
		check[i] = true; // 방문 체크
		
		for (int j : list[i]) { // i에 연결된 노드 가져옴.
			if (!check[j]) {// 방문하지 않았으면 dfs 다시
				dfs(j); // dfs
			}
		}

	}

}
