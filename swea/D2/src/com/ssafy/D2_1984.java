package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		int [] num = new int[10];
		double [] ans = new double[T];
		for (int tc = 0; tc < T; tc++) {
			int sum=0;
			for(int i=0; i<10; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			for(int i = 1; i<9;i++) {
				sum+= num[i];
			}
			ans[tc] = (double)sum/8;
		}
		for(int tc=0; tc<T; tc++) {
			System.out.println("#"+ (tc+1)+" "+String.format("%.0f", ans[tc]));
		}
	}
}
