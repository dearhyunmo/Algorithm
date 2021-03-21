package Q_14490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14490 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(),":"); // :를 기준으로 숫자 분리 인식
		int n1= Integer.parseInt(st.nextToken());
		int n2= Integer.parseInt(st.nextToken());
		int gcdn = gcd(n1,n2); // 최대공약수 함수 호출
		System.out.println((n1/gcdn)+":"+(n2/gcdn)); // 결과 출력
	}
	
	static int gcd(int n1, int n2) { // 최대 공약수
		while(n2!=0) { 
			int r = n1 % n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}
}
