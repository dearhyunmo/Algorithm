package com.ssafy;

import java.util.Scanner;

public class D1_2056 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] d = new int[T];
		int[] year = new int[T];
		int[] month = new int[T];
		int[] day = new int[T];
		int[][] answer = new int[T][3];
		for(int test_case = 1; test_case <= T; test_case++)
		{
            d[test_case-1]= sc.nextInt();
            year[test_case-1] = (d[test_case-1]/10000);
            d[test_case-1] -= (d[test_case-1]/10000)*10000;
            month[test_case-1] = (d[test_case-1]/100);
            d[test_case-1] -= (d[test_case-1]/100)*100;
            day[test_case-1] = d[test_case-1];
		}
		for(int tc=0;tc<T;tc++) {
			if(month[tc]==1||month[tc]==3||month[tc]==5||month[tc]==7||month[tc]==8||month[tc]==10||month[tc]==12) {
				if(day[tc]<1||day[tc]>31) {
					answer[tc][2]=-1;
				}else {
					answer[tc][0]=year[tc];
					answer[tc][1]=month[tc];
					answer[tc][2]=day[tc];
				}
			}else if(month[tc]==2) {
				if(day[tc]<1||day[tc]>28) {
					answer[tc][2]=-1;
				}else {
					answer[tc][0]=year[tc];
					answer[tc][1]=month[tc];
					answer[tc][2]=day[tc];
				}
			}else if(month[tc]==4||month[tc]==6||month[tc]==9||month[tc]==11) {
				if(day[tc]<1||day[tc]>30) {
					answer[tc][2]=-1;
				}else {
					answer[tc][0]=year[tc];
					answer[tc][1]=month[tc];
					answer[tc][2]=day[tc];
				}
			}else
				answer[tc][2]=-1;
		}
		for(int tc=0;tc<T;tc++) {
			if(answer[tc][2]==-1)
				System.out.println("#" + (tc+1) +  " " + answer[tc][2]);
			else
				System.out.println("#" +(tc+1) +  " " +  String.format("%04d", answer[tc][0]) +"/"+String.format("%02d", answer[tc][1])+"/"+String.format("%02d", answer[tc][2]));
		}
	}
}
