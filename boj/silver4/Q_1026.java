package Q_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1026 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 읽어오기
		
		int n = Integer.parseInt(br.readLine()); // 각 배열에 숫자 몇개인지
		
		int[] A = new int[n];
		int[] B = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // 배열에 값넣기
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 배열 정렬
		Arrays.sort(B);
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			ans += A[i] * B[n-1-i]; // 최소가 되려면 하나는 작은 것 부터 하나는 큰 것 부터 가면된다 고로 n-1-i하면 B의 가장 큰 수
		}
		System.out.println(ans);
	}
}
