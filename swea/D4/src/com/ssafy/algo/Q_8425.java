package com.ssafy.algo;

import java.util.Scanner;

public class Q_8425 {
	static Scanner sc;

	public static void main(String args[]) throws Exception {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		int [] sol = new int[T];

		for (int tc = 1; tc <= T; tc++) {
			sol[tc-1] = solution(); // 결과값 배열 저장 
		}
		for(int tc=0; tc<T; tc++)
			System.out.println("#"+(tc+1)+" "+sol[tc]);
	}

	public static int solution() {
		int sol = 0;
		
		int N = sc.nextInt(); // 색의 종류
		
		int[] arr = new int[N]; 
		int xor = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			xor = xor ^ arr[i]; // xor 연산자로 비트 연산
		}
		for (int i = 0; i < N; i++) {
			int need = xor ^ arr[i]; // xor 연산자로 비트 연산
			if (need < arr[i]) // need가 arr[i]값보다 작으면
				sol++; // 해결 가능성
		}
		return sol;
	}
}	