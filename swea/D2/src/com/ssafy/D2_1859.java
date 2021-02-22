package com.ssafy;

import java.util.Scanner;

public class D2_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long sum[] = new long[T]; // 결과값 저장용 배열
		for (int tc = 1; tc <= T; tc++) { // 테스트 케이스
			int N = sc.nextInt(); // 몇번 매매가 뜨는지
			int a[] = new int[N]; // 매매가 뜨는 배열 설정
			for (int i = 0; i < N; i++) 
				a[i] = sc.nextInt(); // 매매가 입력 
			int max = a[N - 1]; 
			for (int i = N - 2; i >= 0; i--) { // 뒤에서 부터
				if (a[i] > max)
					max = a[i];
				else
					sum[tc-1] += max - a[i];
			}
		}
		for(int tc = 0; tc<T;tc++)
			System.out.format("#%d %d\n", tc+1, sum[tc]);
	}
}
