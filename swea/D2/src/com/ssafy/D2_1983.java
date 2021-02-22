package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D2_1983 {

	static int T, N, K, rank;
	static double[] scoreArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] arr = br.readLine().split(" ");
			N = Integer.parseInt(arr[0]); // 학생수
			K = Integer.parseInt(arr[1]); // 알고싶은 번째 학생

			// ------ 총점 저장
			scoreArr = new double[N];
			for (int i = 0; i < N; i++) {
				arr = br.readLine().split(" ");
				scoreArr[i] = Integer.parseInt(arr[0]) * 0.35 + Integer.parseInt(arr[1]) * 0.45
						+ Integer.parseInt(arr[2]) * 0.2;
				// (f) 정수연산이 빠름
			}

			// ------- 랭킹 구하기
			double kScore = scoreArr[K - 1];
			rank = 0;
			for (int i = 0; i < scoreArr.length; i++) {
				if (scoreArr[i] > kScore) {
					rank++;
				}
			}

			// ------- 학점 부여하기
			int dup = N / 10; // 몇명의 학생이 동일한 평점인지 구하기.

			String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

			bw.write("#" + test_case + " " + grade[rank / dup] + "\n");
		} // end of for

		br.close();
		bw.flush();
		bw.close();

	} // end of main
		// 1. 총점을 구하고, 자기가 몇등인지 알아야 한다.

}