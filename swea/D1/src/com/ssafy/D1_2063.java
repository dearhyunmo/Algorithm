package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class D1_2063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nc;
		nc = sc.nextInt();
		int[] num = new int[nc];
		for (int num_count = 0; num_count < nc; num_count++) {
			num[num_count] = sc.nextInt();
		}
		Arrays.sort(num);
		System.out.println(num[(nc/2)]);
	}

}
