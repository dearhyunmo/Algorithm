package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_9940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 횟수
		
		for (int t = 1; t <= T; ++t) { // 테스트 케이스만큼 반복
			int n = Integer.parseInt(br.readLine()); // 배열의 길이
			String result = "Yes"; // 결과값 출력을 위한 변수
			
			String[] str = br.readLine().split(" "); // 배열의 값들을 구분하기 위하여 사용한 split
			
			boolean[] arr = new boolean[n + 1]; //배열의 길이 만큼 boolean형태의 배열
			for (int i = 0; i < n; ++i) {
				int num = Integer.parseInt(str[i]); //str배열의 값을 num변수에 넣기
				arr[num] = true; // 순서에 맞는 값을 boolean형태의 배열에 true값 넣기
			}
			for (int i = 1; i < n + 1; ++i) {
				if (!arr[i]) { // 해당 배열의 값이 false일 경우
					result = "No"; // 결과값은 No
					break;
				}
			}
			System.out.println("#" + t + " " + result);
		}
		br.close();
	}
}