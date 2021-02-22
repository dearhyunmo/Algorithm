package com.ssafy.algo;

import java.io.*;
import java.util.StringTokenizer;

public class Q_7829 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE; // 값 비교를 위한 min 변수 선언
			int max = Integer.MIN_VALUE; // 값 비교를 위한 max 변수 선언
			StringTokenizer st = new StringTokenizer(br.readLine()); // 각각의 약수들을 받아오기 위한 StringTokenizer
			
			for (int i = 0; i < P; i++) {
				int num = Integer.parseInt(st.nextToken()); // st로 받아온 각각의 약수들 비교위해 대입
				if (num > max) // 비교
					max = num;
				if (num < min) // 비교
					min = num;
			}
			int answer = min * max; // 답 계산
			System.out.println("#" + tc + " " + answer); // 답 출력
		}
	}
}
