package com.ssafy;

import java.util.Scanner;

public class D2_2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int []sum = new int[T];
		int N, M;
		for(int tc = 0; tc<T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int [][] map = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<N-(M-1);i++) {
				for(int j=0;j<N-(M-1);j++) {
					int temp=0;
					for(int k=0;k<M;k++) {
						for(int z=0;z<M;z++) {
							temp += map[i+k][j+z];
						}
					}
					if(sum[tc]<temp) {
						sum[tc]=temp;
					}
				}
			}
		}
		for(int tc=0; tc<T; tc++)
			System.out.println("#"+(tc+1)+" "+sum[tc]);
	}

}
