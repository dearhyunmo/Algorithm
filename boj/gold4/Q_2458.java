package gold4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2458 {
	
	//TC
	
	// 6 6 >> 학생들의 수, 두 학생 키를 비교한 횟수
	//	1 5 >>  1번 학생 < 5번 학생
	//	3 4 >> 3번 학생 < 4번 학생
	//	5 4 >> 5번 학생 < 4번 학생
	//	4 2 >> 4번 학생 < 2번 학생
	//	4 6 >> 4번 학생 < 6번 학생
	//	5 2 >> 5번 학생 < 2번 학생
	
	// 여기서 본인이 몇번째 인거 아는건 - 4
	// dfs를 양방향으로 돌려서 학생 수+1(내가 2번 돌아가니까) 번 돌아가면 본인 위치를 아는애들
	
	static boolean [][] compare, Rcompare; // 정방향 비교 여부, 역방향 비교 여부
	static boolean [] visited, Rvisited; // 정방향 방문, 역방향 방문
	static int cnt, N, M; //N+1 비교했는지 볼라거
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 총 비교 횟수
		
		int ans = 0; // 답
		
		compare = new boolean[N+1][N+1]; // 비교 여부 체크용
		Rcompare = new boolean [N+1][N+1]; // 역방향 비교 여부 체크용
		
		for(int i=0; i<M; i++) { //비교횟수만큼 입력을 받으니까 M을 기준
			st = new StringTokenizer(br.readLine());
			
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			
			compare[small][tall] = true; // 정방향 비교 가능 true
			Rcompare[tall][small] = true; // 역방향 비교 가능 true
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1]; //dfs랑 Rdfs 돌ㄸㅐ마다 초기화
			Rvisited = new boolean[N+1]; //dfs랑 Rdfs 돌ㄸㅐ마다 초기화
			cnt = 0; // 카운트 0
			dfs(i);
			Rdfs(i);
			if(cnt == N+1) // 카운트가 N+1이면 내 위치 아는애니까 ㄱㄱ
				ans++;
		}
		System.out.println(ans);
	}
	
	private static void dfs(int num) { // 정방향 비교니까 나보다 큰애들이랑 비교할거야
		cnt++; 
		visited[num]=true; // 방문여부 체크하고
		for(int i=1; i<=N; i++) {
			if(!visited[i] && compare[num][i]) // 아직 방문안했고, 나보다 큰애랑 비교 가능하면
				dfs(i); // dfs또 들어가
		}
	}
	private static void Rdfs(int num) { // 역방향 비교 = 나보다 작은애들이랑 비교
		cnt++;
		Rvisited[num]=true; // 역방향 방문 여부 체크
		for(int i=1; i<=N; i++) { // 
			if(!Rvisited[i] && Rcompare[num][i]) // 아직 방문 안했고 나보다 작은애랑 비교 가능하면
				Rdfs(i); // Rdfs 들어감
		}		
	}
	
}
