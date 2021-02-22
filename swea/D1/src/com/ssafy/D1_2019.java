package com.ssafy;

import java.util.Scanner;

public class D1_2019 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int num =1;
		System.out.print(num+ " ");
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            num*=2;
    		System.out.print(num+" ");
		}
	}
}
