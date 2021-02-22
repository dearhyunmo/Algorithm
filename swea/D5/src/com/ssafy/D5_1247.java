package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D5_1247 {
	static int start_x; // 회사위치 저장
	static int start_y;
	static int home_x; // 집 위치 저장
	static int home_y;
	static int min; // 최소거리 저장
	static int[][] m_list; // 회원들의 집 위치 정보만 저장

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 입력받기

		for (int i = 1; i <= tc; i++) { // 테스트 케이스 반복 실행
			String[] s = new String[30]; // 회원 최대 10명의 위치니깐 크기 넉넉하게 30
			int member = Integer.parseInt(br.readLine()); // 회원 몇명인지
			s = br.readLine().split(" "); // String형 s배열에 저장
			m_list = new int[member][2]; // {{70,40},{30,10},{10,5}.....} 이런식으로 저장
			int[] arr = new int[member]; // 인덱스를 활용할 순열
			int idx = 4;
			min = 999999;
			for (int j = 0; j < member; j++) {
				for (int k = 0; k <= 1; k++) {
					m_list[j][k] = Integer.parseInt(s[idx++]); // 회원의 집정보 저장 중
				}
			}
			for (int j = 0; j < m_list.length; j++) { // 회원 명수만큼의 인덱스를 활용하기 위해
				arr[j] = j;
			}
			start_x = Integer.parseInt(s[0]); // 회사위치 정보 저장
			start_y = Integer.parseInt(s[1]);
			home_x = Integer.parseInt(s[2]); // 집위치 정보 저장
			home_y = Integer.parseInt(s[3]);

			perm(arr, 0, member, member); // 인덱스의 순열 만들기
			System.out.println("#" + i + " " + min);

		}
	}

	// 순열 만들기
	private static void perm(int[] arr, int size, int n, int r) {
		if (size == r) {
			total(arr, size); // 순열 한 세트마다 total로
			return;
		}
		for (int i = size; i < n; i++) {
			swap(arr, i, size);
			perm(arr, size + 1, n, r);
			swap(arr, i, size);
		}
	}

	private static void swap(int[] arr, int i, int size) {
		int temp = arr[i];
		arr[i] = arr[size];
		arr[size] = temp;
	}

	public static void total(int[] arr, int size) {
		int hap = 0;
		int tmpx = start_x; // ***전역변수를 다른 메소드에서 직접 건드리지 말자***
		int tmpy = start_y;

		// 순열 한 세트가 올때마다 hap을 구해줌
		for (int i = 0; i < arr.length; i++) {
			hap += Math.abs(tmpx - m_list[arr[i]][0]) + Math.abs(tmpy - m_list[arr[i]][1]); // m_list에 순열 한 세트인 arr을
																							// 인덱스로 사용
			tmpx = m_list[arr[i]][0]; // 출발하는 곳을 계속 갱신 해줘야됨
			tmpy = m_list[arr[i]][1];
		}
		hap += Math.abs(tmpx - home_x) + Math.abs(tmpy - home_y); // 모든 회원 집 들리고 마지막으로 집으로
		if (min > hap)
			min = hap; // min값을 계속
	}

}
