package com.ssafy;

import java.util.Scanner;

public class D1_1933 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int cnt = 0;
		int idx =0;
		
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				cnt++;
			}
		}
		int answer[] = new int[cnt];
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				answer[idx++] = i; 
			}
		}
		for(int i=0; i<cnt;i++)
			System.out.print(answer[i]+" ");
	}

}
