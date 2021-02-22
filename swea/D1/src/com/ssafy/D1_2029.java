package com.ssafy;

import java.util.Scanner;

public class D1_2029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		int [] num1 = new int[T];
		int [] num2 = new int[T];

		for (int test = 0; test < T; test++) {
			
			num1[test] = sc.nextInt();
			num2[test] = sc.nextInt();
		}
		
		for(int test = 0; test < T; test++) {
			System.out.println("#"+(test+1)+" "+(num1[test]/num2[test])+" "+(num1[test]%num2[test]) );
		}
	}

}
