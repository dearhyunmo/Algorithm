package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D1_2050 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		String msg = in.readLine(); // 엔터 전까지만 입력 받아서 사용 가능;
		char[] cha = msg.toCharArray();
		int[] numa = new int[msg.length()];
		for(int i=0;i<msg.length();i++) {
			if((int)cha[i]>=65&&(int)cha[i]<=90) {
				numa[i] =((int)cha[i]-64);		
			}else	
				numa[i] =((int)cha[i]-96);
			System.out.print(numa[i]+" ");
		}
	}
}