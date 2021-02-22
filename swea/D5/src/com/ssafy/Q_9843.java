package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1 : 1
 * 3 : 2
 * 6 : 3
 * 10 : 4
 * 15 : 5
 * 21 : 6
 * 
 * K(K+1)/2 
 * K(K+1)/2 = N 
 * K(K+1) = 2N
 * K^2 = 2N 
 * K = route(2N)
 * 
  * */
public class Q_9843 {

	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] index = new long[T]; // 결과 저장 및 출력용 배열
		
		for (int tc = 1; tc <= T; ++tc) {
			long num = Long.parseLong(br.readLine());
			long result = 0;
			index[tc - 1] = -1; // -1로 값 초기화
			for (long n = (long) Math.sqrt(num * 2); ; ++n) { // 반복문의 제한을 없애주고 n의 값만 계속 증가
				result = (n * (n + 1)) / 2; // 결과값 계산법 상단 참조
				if (result == num) { // 결과값과 세울 양초의 수가 같다면
					index[tc - 1] = n; // 줄수 출력
					break;
				} else if (result > num) { // 값이 다르다면
					break; // -1로 종료
				}
			}
		}
		for (int tc = 0; tc < T; tc++)
			System.out.println("#" + (tc+1) + " " + index[tc]);
		br.close();
	}
}