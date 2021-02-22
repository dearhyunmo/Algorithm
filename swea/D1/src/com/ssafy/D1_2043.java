package com.ssafy;

import java.util.Scanner;

public class D1_2043 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();
		int K = sc.nextInt();
		int num =0;
		for(int i=K;i<=P; i++)
			num++;
		System.out.println(num);
	}

}
