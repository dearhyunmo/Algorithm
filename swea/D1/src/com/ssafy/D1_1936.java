package com.ssafy;

import java.util.Scanner;

public class D1_1936 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		boolean end= true;
		while(end) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			switch (a) {
			case 1:
				switch (b) {
				case 1:
					System.out.println("무승부는 없다.");
				case 2:
					System.out.println("B");
					end = false;
					break;
				case 3:
					System.out.println("A");
					end = false;
					break;
				}
			case 2:
				switch (b) {
				case 1:
					System.out.println("A");
					end = false;
					break;
				case 2:
					System.out.println("무승부는 없다.");
				case 3:
					System.out.println("B");
					end = false;
					break;
				}
			case 3:
				switch (b) {
				case 1:
					System.out.println("B");
					end = false;
					break;
				case 2:
					System.out.println("A");
					end = false;
					break;
				case 3:
					System.out.println("무승부는 없다.");
				}
			}
		}		
	}
}
