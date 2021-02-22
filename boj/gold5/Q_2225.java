package gold5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2225 {
	// TC
	
	// 20	2	N > 범위 및 더해질 값 / K > 더할 정수 갯수
	
	// 1 / 2 / 3 / 4 / 5 / 6 / 7 / 8 / 9 / 10 / 11 / 12 / 13 / 14 / 15 / 16 / 17 / 18 / 19 / 20
	// 총 20개 2개 더해서 20

	//	if ) N = 5, K = 3
	// 1 2 3 4 5 중 3개 선택하는 경우의 수 :

	/*
		(첫번째 0 , 다시 2개 선택해서 5 만드는거) + (첫번째 1, 다시 2개 선택해서 4 만드는거)
		+ (첫번째 2, 다시 2개 선택해서 3만드는거) + (첫번째 3, 다시 2개 선택해서 2 만드는거)
		+ (첫번째 4, 다시 2개 선택해서 1만드는거) + (첫번째 5, 다시 2개 선택해서 0만드는거)
		=
		(N=5,K=3) = (N=5,K=2)+(N=4,K=2)+(N=3,K=2)+(N=2,K=2)+(N=1,K=2)+(N=0,K=2)
		↓
		(N=i, K=j) = (N=i, K=j-1) + … +(N=0, K=j-1)	
	*/
	
	// N=2, K=1 → 0~2까지 정수 1개를 더해서 N(2)을 만들기 → 2하나만 더해야함 → K=1는 경우의 수 1
	// N = 1, K=3 → 0~1까지 정수 3개를 더해서 N(1)을 만들기 → 0+0+1 / 0+1+0 / 1+0+0 해서 해야하니까 경우의 수 3
	// K = 1 → 1
	// N =1 → K
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 범위 및 더해질 값
		int K = Integer.parseInt(st.nextToken()); // 더할 정수 갯수

		int[][] dp = new int[N+1][K+1]; // dp 범위 지정

		for(int i=1; i<=K; i++) {
			dp[1][i] =i; // N=1일때는 K의 값으로
		}
		
		for(int i=1; i<=N; i++) {
			dp[i][1] = 1; // K=1일때는 N의 값으로
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=2; j<=K; j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000; 
			}
		}

		System.out.println(dp[N][K]);
	}
}
