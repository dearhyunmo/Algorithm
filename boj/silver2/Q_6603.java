package silver2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_6603 {
	public static int[] num;
	public static boolean[] visit;
	
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		
		sb = new StringBuilder();

		while (true) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());

			if (k == 0)	break;
			num = new int[k];
			visit = new boolean[k];
			
			for (int i = 0; i < k; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<k;i++) {
				if(i+6 > k) continue;
				visit[i] = true;
				backtracking(i, 1, num[i] + " ");
				visit[i] = false;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void backtracking(int idx, int cnt, String str) {
		if(idx >= num.length || idx + 6 - cnt > num.length) return;
		if(cnt == 6) {
			sb.append(str + "\n");
			return;
		}
		
		for(int i=idx+1; i<num.length; i++) {
			if(visit[i])continue;
			visit[i] = true;
			backtracking(i, cnt+1, str+num[i]+" ");
			visit[i] = false;
		}
		
	}

}
