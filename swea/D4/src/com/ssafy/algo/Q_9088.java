package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;

public class Q_9088 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] result = new int[T];

		for (int tc = 1; tc <= T; ++tc) {
	
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int[] dia = new int[10001]; // 배열의 크기가 10001인것은 다이아 사이즈는 최대 10000
			int max = 0;
			int min = 10001;
			
			for (int i = 0; i < n; ++i) {
			
				int size = Integer.parseInt(br.readLine());
				
				if (max < size) { // 반복문 설정을 위한 max값 설정
					max = size;
				}
				if (min > size) {
					min = size;
				}
				
				dia[size]++; 
			}

			for (int i = min; i < max + 1; ++i) { // 사이즈별로 반복문
				int sum = 0;
			
				for (int j = i; j < (i + k + 1 > 10001 ? 10001 : i + k + 1); ++j) { // 다이아 갯수 입력
					sum += dia[j];
				}
				
				if (sum > result[tc - 1]) {
					result[tc - 1] = sum; // 선물할수 있는 다이아 갯수 결과에 대입
				}
			}
		}
		
		for (int tc = 0; tc < T; tc++) {
			System.out.println("#" + (tc + 1) + " " + result[tc]); // 결과 출력
		}
		
		br.close();
	}
}