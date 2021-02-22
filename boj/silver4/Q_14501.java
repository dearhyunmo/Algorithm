package silver4;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 10];
		int[] P = new int[N + 10];
		int[] dp = new int[N + 10];
		int max = 0;
		String[] str;
		for (int i = 1; i <= N; i++) {
			str = br.readLine().split(" ");
			T[i] = Integer.parseInt(str[0]);
			P[i] = Integer.parseInt(str[1]);
		}

		for (int i = 1; i <= N + 1; i++) {
			if(dp[i]<max)
				dp[i] = max;
			dp[T[i] + i] = Math.max(dp[T[i] + i], P[i] + dp[i]);
			if(dp[i]>max)
				max = dp[i];
		}
		System.out.println(max);
	}

}
