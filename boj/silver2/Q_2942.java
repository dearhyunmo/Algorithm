package silver2;


import java.util.*;
import java.io.*;

public class Q_2942 {

	public static int gcd(int a, int b) { // 최대공약수 4,8

		if (b == 0) {
			return a;
		}

		return gcd(b, a % b); // 
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken()); // 빨강사과 줄까
		int g = Integer.parseInt(st.nextToken());// 초록사과 줄까

		int gcd = gcd(r, g); // 최대공약수 구하기

		for (int n = 1; n <= gcd; n++) { // 최대공약수 만큼 반복

			if (gcd % n == 0) {
				sb.append(n + " " + (r / n) + " " + (g / n) + "\n");
			}

		}

		System.out.println(sb.toString());
	}

}
