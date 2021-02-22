package com.ssafy;

import java.util.Scanner;

public class D1_2058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int [] arr = new int[3];
		int sum = 0;
		
		sum+=num/1000;
		num -= (num/1000)*1000;
		
		sum+=num/100;
		num -=(num/100)*100;
		
		sum+=num/10;
		num -=(num/10)*10;

		sum +=num;
		
		System.out.println(sum);
	}

}
