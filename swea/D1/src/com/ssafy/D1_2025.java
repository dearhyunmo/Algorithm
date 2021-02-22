package com.ssafy;

import java.util.Scanner;

public class D1_2025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int tot = 0;
		
		for(int i=1;i<=num;i++) {
			tot += i;
		}
		System.out.println(tot);
	}

}
