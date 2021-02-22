package com.ssafy;

import java.util.Scanner;

public class D2_1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int [] ans = new int[T];
		for (int tc = 0; tc < T; tc++) {
			int num = sc.nextInt();
			for (int i = 1; i <= num; i++) {
				if(i%2==1)
					ans[tc]+=i;
				else
					ans[tc]-=i;
			}
		}
		
		for(int tc=0; tc<T; tc++)
			System.out.println("#" + (tc+1)+ " "+ ans[tc]);
	}
}
