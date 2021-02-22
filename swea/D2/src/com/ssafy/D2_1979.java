package com.ssafy;

import java.util.Scanner;

public class D2_1979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		int [][] Map = new int[T][T];
		
		for (int tc = 0; tc < T; tc++) {
			int cnt = 0;
			int N = sc.nextInt();
			int txt = sc.nextInt();
			
			for(int i=0; i<N; i++) {
				for(int j=0;j<N;j++) {
					Map[i][j]=sc.nextInt();
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
				}
			}

		}
	}
}
