package com.ssafy;

import java.util.Scanner;

public class D2_2005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int sum = 0;

		for (int tc = 0; tc < T; tc++) {
			int line = sc.nextInt();
			int [][] num = new int[line][line];
			System.out.println("#"+(tc+1));
			for (int i = 0; i < line; i++) {
				for (int j = 0; j < i + 1; j++) {
					if(j==0) {
						num[i][j]=1;
						System.out.print(1+"\t");
					}else if(j==i){
						num[i][j]=1;
						if(i<line-1) {
							num[i+1][j] = (num[i][j]+num[i][j-1]);	
							//System.out.println(num[i][j]);
						}
						System.out.print(1);
					}
					else {
						if(i<line-1) {
							num[i+1][j] = num[i][j]+num[i][j-1];	
						}
						System.out.print(num[i][j]+"\t");
					}
				}
				System.out.println();
			}
		}

	}

}
